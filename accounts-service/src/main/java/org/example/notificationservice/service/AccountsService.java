package org.example.notificationservice.service;

import org.example.notificationservice.model.Accounts;
import org.example.notificationservice.model.BankDTO;
import org.example.notificationservice.repository.IAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class AccountsService {

  private final IAccountRepository repository;
  private final WebClient bankWebClient;

  public AccountsService(IAccountRepository repository, WebClient bankWebClient) {
      this.repository = repository;
      this.bankWebClient = bankWebClient;
  }

  public Mono<Accounts> create(Accounts accounts) {
    return this.bankWebClient.get()
            .uri("/api/banks/" + accounts.getBankId())
            .retrieve()
            .bodyToMono(BankDTO.class)
            .switchIfEmpty(Mono.error(new RuntimeException("Bank don't exist")))
            .flatMap(bankDTO -> this.repository.save(accounts));
  }

  public Mono<List<Accounts>> list() {
    return this.repository.findAll().collectList();
  }

  public Mono<Accounts> findById(String id) {
    return this.repository.findById(id);
  }

  public Mono<Accounts> update(Accounts account) {
      return this.bankWebClient.get()
              .uri("/api/banks/" + account.getBankId())
              .retrieve()
              .bodyToMono(BankDTO.class)
              .switchIfEmpty(Mono.error(new RuntimeException("Bank don't exist")))
              .flatMap(bankDTO -> this.repository.findById(account.getId())
                      .flatMap(accountInDb -> {
                          accountInDb.setBankId(account.getBankId());
                          return this.repository.save(accountInDb);
                  }));
  }

  public Mono<Void> delete(String id) {
    return this.repository.deleteById(id).then();
  }


}
