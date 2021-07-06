package com.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.TransferServiceConfiguration;
import com.example.service.TransferService;

public class App {

	public static void main(String[] args) {

		// init / boot phase

		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(TransferServiceConfiguration.class);

		// use phase
		TransferService transferService = applicationContext.getBean(TransferService.class);

		transferService.transfer(1000.00, "1", "2");

		System.out.println();

		transferService.transfer(1000.00, "2", "1");

		// destroy phase
		applicationContext.close();

	}

}
