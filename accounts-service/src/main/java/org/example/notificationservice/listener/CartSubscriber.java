package org.example.notificationservice.listener;

import org.example.notificationservice.model.Accounts;
import org.example.notificationservice.service.AccountsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CartSubscriber {
  private final AccountsService accountsService;

  public CartSubscriber(AccountsService accountsService) {
    this.accountsService = accountsService;
  }
//
//  @RabbitListener(queues = "cart-queue")
//  public void receiveCart(Accounts accounts) {
//    accountsService.sendEmail(accounts.getUserEmail(), "Confirmación de compra", "Gracias por tu compra! " + accounts.getProducts().size());
//  }

}
