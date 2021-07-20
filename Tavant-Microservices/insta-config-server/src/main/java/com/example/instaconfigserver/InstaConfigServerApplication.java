package com.example.instaconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class InstaConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstaConfigServerApplication.class, args);
	}

}
