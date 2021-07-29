package com.example.springreactiveweb.service;

import com.example.springreactiveweb.model.Customer;
import com.example.springreactiveweb.repository.CustomerAsyncRepository;
import com.example.springreactiveweb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerAsyncRepository customerAsyncRepository;

    public List<Customer> loadAllCustomers() {
        long start = System.currentTimeMillis();
        List<Customer> customers = customerRepository.getCustomers();
        long end = System.currentTimeMillis();
        System.out.println("Total execution time : " + (end - start));
        return customers;
    }


    public Flux<Customer> loadAllCustomersStream() {
        long start = System.currentTimeMillis();
        Flux<Customer> customers = customerRepository.getCustomersStream();
        long end = System.currentTimeMillis();
        System.out.println("Total execution time : " + (end - start));
        return customers;
    }


    public Mono<Customer> createAsync(Customer customer){
        System.out.println(customer);
        return customerAsyncRepository.save(customer);
    }
    public Mono<Customer> getAsync(int id){
        return customerAsyncRepository.findById(id);
    }


}
