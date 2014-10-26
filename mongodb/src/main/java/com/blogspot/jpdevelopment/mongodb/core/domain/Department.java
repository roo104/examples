package com.blogspot.jpdevelopment.mongodb.core.domain;

import org.springframework.data.annotation.Id;

public class Department {

	@Id
	private final String name;

	public Department(String name) {
		this.name = name;
	}

}
