package org.example.cartservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("banks")
public class Bank {
  @Id
  private String id;
  private String name;
  private LocalDateTime createdDate;

  public Bank() {
  }

  public Bank(String id, String name, LocalDateTime createdDate) {
    this.id = id;
    this.name = name;
    this.createdDate = createdDate;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUserName() {
    return name;
  }

  public void setUserEmail(String name) {
    this.name = name;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }
}
