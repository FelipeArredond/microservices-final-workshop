package org.example.cartservice.repository;

import org.example.cartservice.model.Transfer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ITransferRepository extends ReactiveCrudRepository<Transfer, String> {
}
