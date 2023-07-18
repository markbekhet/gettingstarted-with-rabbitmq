package com.example.rabbitmqtutorial;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "${queueName}")
public class Receiver {

    private final int instance;
    public Receiver(int n){
        this.instance = n;
    }
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.printf("Instance %d Received <"+ message + ">%n", instance);
    }

}
