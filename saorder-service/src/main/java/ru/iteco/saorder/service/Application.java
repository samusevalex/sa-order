package ru.iteco.saorder.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"ru.iteco.saorder", "ru.iteco.config"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}