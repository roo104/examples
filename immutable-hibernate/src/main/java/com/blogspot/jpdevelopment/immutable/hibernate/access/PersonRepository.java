package com.blogspot.jpdevelopment.immutable.hibernate.access;

import java.util.UUID;

import com.blogspot.jpdevelopment.immutable.hibernate.access.domain.Person;

public interface PersonRepository {

	public void storePerson(Person person);

	public Person getPerson(UUID id);
}
