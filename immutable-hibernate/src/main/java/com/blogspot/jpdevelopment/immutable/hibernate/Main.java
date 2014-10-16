package com.blogspot.jpdevelopment.immutable.hibernate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.blogspot.jpdevelopment.immutable.hibernate.access.PersonAccessRepository;
import com.blogspot.jpdevelopment.immutable.hibernate.access.domain.Person;
import com.blogspot.jpdevelopment.immutable.hibernate.configuration.Application;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);
		PersonAccessRepository accessRepository = ctx.getBean(PersonAccessRepository.class);

		Person person = new Person("J", "P");
		accessRepository.storePerson(person);

		Person storedPerson = accessRepository.getPerson(person.getId());
	}

}
