package com.example;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	ProductRepository repository() {
		ProductRepository repository = new ProductRepository();
		repository.add(new Product("Test1", 1000));
		repository.add(new Product("Test2", 1500));
		repository.add(new Product("Test3", 2000));
		repository.add(new Product("Test4", 3000));
		repository.add(new Product("Test5", 1300));
		repository.add(new Product("Test6", 2700));
		repository.add(new Product("Test7", 3500));
		repository.add(new Product("Test8", 1250));
		repository.add(new Product("Test9", 2450));
		repository.add(new Product("Test10", 800));
		return repository;
	}
}
