package org.example.cartservice.dto;

import java.time.LocalDateTime;
import java.util.List;

public class BankDTO {
  private String id;
  private String name;
  private LocalDateTime createdDate;

  public BankDTO() {
  }

  public BankDTO(String id, String name, LocalDateTime createdDate) {
    this.id = id;
    this.name = name;
    this.createdDate = createdDate;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public LocalDateTime getCreatedDate() {
    return this.createdDate;
  }
}
