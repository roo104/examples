package com.blogspot.jpdevelopment.mongodb.config;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.DB;
import com.mongodb.MongoClient;

@Configuration
@ComponentScan("com.blogspot.jpdevelopment.mongodb")
public class MongoDbConfig {

	@Bean
	public MongoClient mongoClient() throws UnknownHostException {
		return new MongoClient("localhost");
	}

	@Bean
	public DB db() throws UnknownHostException {
		return mongoClient().getDB("test");
	}

	@Bean
	public MongoDbFactory mongoDbFactory() throws UnknownHostException {
		return new SimpleMongoDbFactory(mongoClient(), "test");
	}

	@Bean
	public MongoTemplate mongoTemplate() throws UnknownHostException {
		return new MongoTemplate(mongoDbFactory());
	}
}
