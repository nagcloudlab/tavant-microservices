package com.example.springreactiveweb.web;

import com.example.springreactiveweb.model.Customer;
import com.example.springreactiveweb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping(value = "/api/customers")
    public List<Customer> getAllCustomers() {
        return service.loadAllCustomers();
    }


    @GetMapping(value = "api/customers/stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomersStream() {
        return service.loadAllCustomersStream();
    }


    @PostMapping("/api/customers")
    public Mono<Customer> saveCustomer(@RequestBody Customer customer){
        return service.createAsync(customer);
    }

    @GetMapping("/api/customers/{id}")
    public Mono<Customer> getCustomer(@PathVariable int id){
        return service.getAsync(id);
    }
}
