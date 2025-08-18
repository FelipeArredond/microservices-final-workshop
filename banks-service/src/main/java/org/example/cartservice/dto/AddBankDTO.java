package org.example.cartservice.dto;

public class AddBankDTO {
  private String name;

  public AddBankDTO(String name) {
    this.name = name;
  }

  public AddBankDTO() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
