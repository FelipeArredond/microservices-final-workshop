package org.example.notificationservice.repository;

import org.example.notificationservice.model.Accounts;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IAccountRepository extends ReactiveCrudRepository<Accounts, String> {
}
