package com.blogspot.jpdevelopment.hibernate.immutable.core.domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {

	@Id
	@Column(columnDefinition = "BINARY(16)", length = 16)
	private final UUID id;
	private final Date creationDate;
	private final String firstname;
	private final String lastname;

	// Hibernate needs this or it will fail with an InstantiationException
	private Person() {
		this.id = UUID.randomUUID();
		this.creationDate = new Date();
		this.firstname = null;
		this.lastname = null;
	}

	public Person(String firstname, String lastname) {
		this.id = UUID.randomUUID();
		this.creationDate = new Date();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public UUID getId() {
		return this.id;
	}

	public String getFullName() {
		return this.firstname + " " + this.lastname;
	}

	@Override
	public String toString() {
		return "Person [id=" + this.id + ", creationDate=" + this.creationDate + ", firstname=" + this.firstname
				+ ", lastname=" + this.lastname + "]";
	}


}
