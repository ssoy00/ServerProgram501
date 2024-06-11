package com.busanit501.lsylunchproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LsyLunchProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(LsyLunchProjectApplication.class, args);
    }

}
