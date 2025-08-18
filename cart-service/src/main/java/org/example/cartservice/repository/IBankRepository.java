package org.example.cartservice.repository;

import org.example.cartservice.model.Bank;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IBankRepository extends ReactiveCrudRepository<Bank, String> {
}
