package org.example.cartservice.service;

import org.example.cartservice.dto.BankDTO;
import org.example.cartservice.model.Bank;
import org.example.cartservice.repository.IBankRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BankService {

  private final IBankRepository bankRepository;

  public BankService(IBankRepository bankRepository) {
    this.bankRepository = bankRepository;
  }

  public Mono<List<Bank>> getAll() {
    return this.bankRepository.findAll().collectList();
  }

  public Mono<BankDTO> getById(String id) {
      return this.bankRepository.findById(id)
              .map(bank -> new BankDTO(bank.getId(), bank.getName(), bank.getCreatedDate()));
  }

  public Mono<Bank> create(String name) {
    return this.bankRepository.save(new Bank(null, name, LocalDateTime.now()));
  }

  public Mono<Void> delete(String bankId) {
      return this.bankRepository.deleteById(bankId).then();
  }

  public Mono<BankDTO> update(BankDTO bankDto) {
    return this.bankRepository.findById(bankDto.getId())
            .flatMap(existingBank -> {
              existingBank.setName(bankDto.getName());
              return this.bankRepository.save(existingBank);
            })
            .map(updatedBank -> new BankDTO(
                    updatedBank.getId(),
                    updatedBank.getName(),
                    updatedBank.getCreatedDate()
            ));
  }

}
