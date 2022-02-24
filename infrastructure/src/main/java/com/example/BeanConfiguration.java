package com.example;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.example")
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.example")
@EntityScan(basePackages = "com.example")
public class BeanConfiguration {

    @Bean
    AccountService accountService(AccountRepository accountRepository){
        return new AccountServiceImpl(accountRepository);
    }
}
