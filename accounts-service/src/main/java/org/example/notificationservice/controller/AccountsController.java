package org.example.notificationservice.controller;

import org.example.notificationservice.model.Accounts;
import org.example.notificationservice.service.AccountsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountsController {

    private final AccountsService service;

    public AccountsController(AccountsService service) {
        this.service = service;
    }

    @GetMapping("/")
    public Mono<ResponseEntity<List<Accounts>>> getAll() {
        return this.service.list().map(ResponseEntity::ok);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Accounts>> getById(@PathVariable String id) {
        return this.service.findById(id).map(ResponseEntity::ok);
    }

    @PostMapping("/")
    public Mono<ResponseEntity<Accounts>> create(@RequestBody Accounts account) {
        return this.service.create(account).map(ResponseEntity::ok);
    }

    @PutMapping("/")
    public Mono<ResponseEntity<Accounts>> update(@RequestBody Accounts accounts) {
        return this.service.update(accounts).map(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {
        return this.service.delete(id).thenReturn(ResponseEntity.accepted().build());
    }

}
