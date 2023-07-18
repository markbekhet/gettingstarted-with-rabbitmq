package com.example.rabbitmqtutorial;

import jdk.jfr.consumer.RecordedEvent;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Value("${runnableExchange}")
    private String topicExchangeName;

    @Value("${queueName}")
    private String queueName;

    @Value("${fooRoutingKey}")
    private String fooRoutingKey;

    @Bean
    Queue queue(){
        return new Queue(queueName);
    }

    private static class ReceiverConfig {
        @Bean
        public Receiver receiver1(){
            return new Receiver(1);
        }

        @Bean
        public Receiver receiver2(){
            return new Receiver(2);
        }
    }
}
