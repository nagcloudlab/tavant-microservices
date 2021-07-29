package com.example.springreactiveweb.repository;

import com.example.springreactiveweb.model.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAsyncRepository extends ReactiveCrudRepository<Customer,Integer> {
}
