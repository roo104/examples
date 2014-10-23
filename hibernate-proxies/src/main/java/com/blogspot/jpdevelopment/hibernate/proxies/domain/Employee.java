package com.blogspot.jpdevelopment.hibernate.proxies.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(columnDefinition = "BINARY(16)", length = 16)
	private final UUID id;
	private final String name;
	private final String title;
	@OneToOne(fetch = FetchType.LAZY)
	private final Department department;

	private Employee() {
		this.id = UUID.randomUUID();
		this.name = null;
		this.title = null;
		this.department = null;
	}

	public Employee(String name, String title, Department department) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.title = title;
		this.department = department;
	}

	public UUID getId() {
		return this.id;
	}

	public Department getDepartment() {
		return this.department;
	}
}
