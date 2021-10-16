package com.freemanpivo.bankapp.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.freemanpivo.bankapp"})
public class BankApp {

    public static void main(String[] args) {
        SpringApplication.run(BankApp.class);
    }
}
