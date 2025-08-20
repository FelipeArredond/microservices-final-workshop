package org.example.cartservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("transfers")
public class Transfer {
  @Id
  private String id;
  private String sourceAccount;
  private String destinationAccount;
  private String type;
  private LocalDateTime createdDate;

  public Transfer() {
  }

  public Transfer(String id, String sourceAccount, String destinationAccount, String type, LocalDateTime createdDate) {
    this.id = id;
    this.sourceAccount = sourceAccount;
    this.destinationAccount = destinationAccount;
    this.type = type;
    this.createdDate = createdDate;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public String getSourceAccount() {
    return sourceAccount;
  }

  public String getDestinationAccount() {
    return destinationAccount;
  }

  public String getType() {
    return type;
  }

  public void setSourceAccount(String sourceAccount) {
    this.sourceAccount = sourceAccount;
  }

  public void setDestinationAccount(String destinationAccount) {
    this.destinationAccount = destinationAccount;
  }

  public void setType(String type) {
    this.type = type;
  }
}
