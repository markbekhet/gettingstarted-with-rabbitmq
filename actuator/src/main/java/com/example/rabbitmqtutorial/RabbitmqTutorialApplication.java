package com.example.rabbitmqtutorial;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitmqTutorialApplication {
	public static void main(String[] args) {
		SpringApplication.run(RabbitmqTutorialApplication.class, args);
	}

}
