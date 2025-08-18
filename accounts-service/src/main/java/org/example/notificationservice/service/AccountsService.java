package org.example.notificationservice.service;

import org.example.notificationservice.model.Accounts;
import org.example.notificationservice.repository.IAccountRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class AccountsService {

  private final IAccountRepository repository;

  public AccountsService(IAccountRepository repository) {
      this.repository = repository;
  }

  public Mono<Accounts> create(Accounts accounts) {
    return this.repository.save(accounts);
  }

  public Mono<List<Accounts>> list() {
    return this.repository.findAll().collectList();
  }

  public Mono<Accounts> findById(String id) {
    return this.repository.findById(id);
  }

  public Mono<Accounts> update(Accounts account) {
    return this.repository.findById(account.getId())
            .flatMap(accountInDb -> {
              accountInDb.setBankId(account.getBankId());
              return this.repository.save(accountInDb);
            });
  }

  public Mono<Void> delete(String id) {
    return this.repository.deleteById(id).then();
  }


}
