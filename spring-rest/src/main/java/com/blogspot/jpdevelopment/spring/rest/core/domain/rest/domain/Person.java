package com.blogspot.jpdevelopment.spring.rest.core.domain.rest.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Person implements Serializable {

	private UUID id;
	private Date creationDate;
	private String firstname;
	private String lastname;

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "Person [id=" + this.id + ", creationDate=" + this.creationDate + ", firstname=" + this.firstname
				+ ", lastname=" + this.lastname + "]";
	}

}
