package com.blogspot.jpdevelopment.spring.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.blogspot.jpdevelopment.spring.rest"})
public class RestConfig extends WebMvcConfigurerAdapter {

}
