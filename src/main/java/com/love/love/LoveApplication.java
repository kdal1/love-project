package com.love.love;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.love")
@EnableJpaRepositories("com.love.repository")
@EnableTransactionManagement
@EntityScan("com.love.entity")
public class LoveApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoveApplication.class, args);
    }
}
