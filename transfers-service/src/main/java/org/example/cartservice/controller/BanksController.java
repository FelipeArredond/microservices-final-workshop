package org.example.cartservice.controller;

import org.example.cartservice.dto.BankDTO;
import org.example.cartservice.model.Transfer;
import org.example.cartservice.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/banks")
public class BanksController {
  private final TransferService service;

  public BanksController(TransferService service) {
    this.service = service;
  }

  @PostMapping("/{name}")
  public Mono<ResponseEntity<BankDTO>> create(@PathVariable String name) {
    return service.create(name).map(transfer ->
            ResponseEntity.ok(new BankDTO(transfer.getId(), transfer.getName(), transfer.getCreatedDate())));
  }

  @DeleteMapping("/{id}")
  public Mono<ResponseEntity> delete(@PathVariable String id) {
    return service.delete(id).thenReturn(ResponseEntity.accepted().build());
  }

  @GetMapping("/")
  public Mono<ResponseEntity<List<Transfer>>> list() {
    return service.getAll().map(ResponseEntity::ok);
  }

  @GetMapping("/{id}")
  public Mono<ResponseEntity<BankDTO>> listById(@PathVariable String id) {
    return service.getById(id).map(ResponseEntity::ok);
  }

  @PutMapping("/{id}/{name}")
  public Mono<ResponseEntity<BankDTO>> update(@PathVariable String id, @PathVariable String name) {
    return service.update(new BankDTO(id, name, null)).map(ResponseEntity::ok);
  }

}
