package com.example.instamediaservice.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class Welcome {

    @Value("${welcome.message:Hello}")
    String message;

    @GetMapping(value = "/")
    public String getMessage() {
        return message;
    }
}
