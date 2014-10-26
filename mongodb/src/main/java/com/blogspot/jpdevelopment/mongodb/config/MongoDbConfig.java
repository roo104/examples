package com.blogspot.jpdevelopment.mongodb.config;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.DB;
import com.mongodb.MongoClient;

@Configuration
public class MongoDbConfig {

	@Bean
	public MongoClient mongoClient() throws UnknownHostException {
		return new MongoClient("localhost");
	}

	@Bean
	public DB db() throws UnknownHostException {
		return mongoClient().getDB( "test" );
	}
}
