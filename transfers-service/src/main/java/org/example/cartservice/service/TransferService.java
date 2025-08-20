package org.example.cartservice.service;

import org.example.cartservice.dto.BankDTO;
import org.example.cartservice.model.Transfer;
import org.example.cartservice.repository.ITransferRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransferService {

  private final ITransferRepository transferRepository;

  public TransferService(ITransferRepository transferRepository) {
    this.transferRepository = transferRepository;
  }

  public Mono<List<Transfer>> getAll() {
    return this.transferRepository.findAll().collectList();
  }


  public Mono<Transfer> create(String sourceAccount, String destinationAccount) {
      var type = "";
      return this.transferRepository.save(new Transfer(null, sourceAccount, destinationAccount, type, LocalDateTime.now()));
  }

}
