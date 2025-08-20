package org.example.cartservice.listener;

import org.example.cartservice.model.Transfer;
import org.example.cartservice.service.TransferService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CartSubscriber {
  private final TransferService transferService;

    public CartSubscriber(TransferService transferService) {
        this.transferService = transferService;
    }


  @RabbitListener(queues = "cart-queue")
  public void receiveCart(Transfer transfer) {
    transferService.create("" , "");
  }

}
