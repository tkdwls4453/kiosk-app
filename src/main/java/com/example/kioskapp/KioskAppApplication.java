package com.example.kioskapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class KioskAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(KioskAppApplication.class, args);
    }

}
