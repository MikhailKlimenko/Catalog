package com.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.catalog.repository")
@EntityScan("com.catalog.model")
@SpringBootApplication
public class SpringBoot {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot.class, args);
    }
}
