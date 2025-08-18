package org.example.notificationservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("accounts")
public class Accounts {
  @Id
  private String id;
  private String bankId;

  public Accounts() {
  }

  public Accounts(String id, String bankId) {
    this.id = id;
    this.bankId = bankId;
  }

  public String getId() {
    return id;
  }

  public String getBankId() {
    return bankId;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setBankId(String bankId) {
    this.bankId = bankId;
  }
}
