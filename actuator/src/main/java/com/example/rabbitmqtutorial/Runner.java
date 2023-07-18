package com.example.rabbitmqtutorial;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.atomic.AtomicInteger;

public class Runner{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${queueName}")
    private String queueName;

    AtomicInteger count = new AtomicInteger(0);
    @Scheduled(fixedDelay = 10000, initialDelay = 50000)
    public void send(){
        System.out.println("sending message ...");
        rabbitTemplate.convertAndSend(queueName,
                "Hello from RabbitMQ " + count.incrementAndGet());
    }
}
