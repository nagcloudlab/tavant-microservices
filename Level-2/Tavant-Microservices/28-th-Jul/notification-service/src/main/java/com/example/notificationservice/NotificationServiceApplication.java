package com.example.notificationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
public class NotificationServiceApplication {

	@Autowired
	EmailSender emailSender;

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}


	@Bean
	public Consumer<String> notficationEventSuppliers(){
		return message->{
			emailSender.sendEmail(message);
		};
	}

}
