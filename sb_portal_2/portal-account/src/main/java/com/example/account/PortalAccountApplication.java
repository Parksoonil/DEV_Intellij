package com.example.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//(scanBasePackages = {"com.example.common", "com.example.account"})
public class PortalAccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(PortalAccountApplication.class, args);
    }
} 