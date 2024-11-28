package com.example.ch4_user_currency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Ch4UserCurrencyApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch4UserCurrencyApplication.class, args);
    }

}
