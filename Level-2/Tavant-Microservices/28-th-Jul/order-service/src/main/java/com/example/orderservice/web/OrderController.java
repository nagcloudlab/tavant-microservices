package com.example.orderservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class OrderController {

    @Autowired
    StreamBridge streamBridge;

    @PostMapping(value = "/api/orders")
    public Mono<String> placeNewOrder() {
        String message = "ORDER " + UUID.randomUUID();
        streamBridge.send("notificationEventSupplier-out-0", message);
        return Mono.just("Ok");
    }

}
