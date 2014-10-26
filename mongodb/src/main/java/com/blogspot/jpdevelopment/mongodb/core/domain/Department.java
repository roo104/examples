package com.blogspot.jpdevelopment.mongodb.core.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Department {

	@Id
	private final String name;

	public Department(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [name=" + this.name + "]";
	}

}
