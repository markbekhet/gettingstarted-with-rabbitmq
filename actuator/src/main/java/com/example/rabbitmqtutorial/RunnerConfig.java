package com.example.rabbitmqtutorial;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RunnerConfig {
    @Bean
    public Runner sender(){
        return new Runner();
    }
}
