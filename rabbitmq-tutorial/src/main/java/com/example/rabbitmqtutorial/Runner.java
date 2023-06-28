package com.example.rabbitmqtutorial;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private final RabbitTemplate rabbitTemplate;
    public Runner(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("sending message ...");
        rabbitTemplate.convertAndSend(RabbitmqTutorialApplication.topicExchangeName,
                "foo.bar.baz", "Hello from RabbitMQ");
    }
}
