package com.blogspot.jpdevelopment.spring.validation.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@ComponentScan(basePackages = {"com.blogspot.jpdevelopment.spring.validation"})
public class RestConfig  {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(RestConfig.class, args);
    }
}
