package com.blogspot.jpdevelopment.immutable.hibernate.access.domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public final class Person {

	@Id
	@Column(columnDefinition = "BINARY(16)", length = 16)
	private final UUID id;
	private final Date creationDate;
	private final String firstname;
	private final String lastname;

	public Person() {
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

	@Override
	public String toString() {
		return "Person [id=" + this.id + ", creationDate=" + this.creationDate + ", firstname=" + this.firstname
				+ ", lastname=" + this.lastname + "]";
	}


}
