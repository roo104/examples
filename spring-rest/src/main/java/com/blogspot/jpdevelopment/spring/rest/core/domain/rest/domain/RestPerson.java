package com.blogspot.jpdevelopment.spring.rest.core.domain.rest.domain;

import com.blogspot.jpdevelopment.mongodb.core.domain.Person;

import java.io.Serializable;
import java.util.UUID;

public class RestPerson implements Serializable {

	private UUID id;
	private String name;
	private String title;

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Person toPersion() {
		return new Person(this.name, title, null);
	}

	public static RestPerson fromPerson(Person person) {
		RestPerson restPerson = new RestPerson();
		restPerson.setId(person.getId());
		restPerson.setName(person.getName());
		restPerson.setTitle(person.getTitle());
		return restPerson;

	}
}
