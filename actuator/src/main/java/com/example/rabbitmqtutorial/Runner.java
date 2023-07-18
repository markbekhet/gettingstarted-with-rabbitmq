package com.example.rabbitmqtutorial;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private final RabbitTemplate rabbitTemplate;
    public Runner(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${runnableExchange}")
    private String exchange;

    @Value("${fooRoutingKey}")
    private String routing;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("sending message ...");
        rabbitTemplate.convertAndSend(exchange,
                routing, "Hello from RabbitMQ");
    }
}
