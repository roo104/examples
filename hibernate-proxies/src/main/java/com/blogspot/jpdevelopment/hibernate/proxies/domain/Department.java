package com.blogspot.jpdevelopment.hibernate.proxies.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	@Id
	private final String name;

	public Department() {
		this.name = null;
	}

	public Department(String name) {
		this.name = name;
	}

}
