package com.example.notificationservice;

import org.springframework.stereotype.Service;

@Service
public class EmailSender {

    public void sendEmail(String message){
        System.out.println("Email : "+message +"");
    }
}
