package com.blogspot.jpdevelopment.mongodb.core.domain;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.annotation.Id;

public class Person implements Serializable {

	@Id
	private final UUID id;
	private final String name;
	private final String title;
	private final Department department;

	public Person(String name, String title, Department department) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.title = title;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	public UUID getId() {
		return this.id;
	}

	public Department getDepartment() {
		return this.department;
	}
}
