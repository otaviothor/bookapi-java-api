package com.bookapi.main;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class BookapiMain {

    @Value("${spring.profiles.active:default}")
    private String activeProfile;

    public static void main(String[] args) {
        SpringApplication.run(BookapiMain.class, args);
    }

    @Bean
    CommandLineRunner logStartupProfile() {
        return args -> {
            log.info("BookAPI application started successfully!");
            log.info("Active Spring profile: {}", activeProfile);
        };
    }
}