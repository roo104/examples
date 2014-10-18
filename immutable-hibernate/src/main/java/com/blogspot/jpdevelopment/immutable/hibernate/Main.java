package com.blogspot.jpdevelopment.immutable.hibernate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.blogspot.jpdevelopment.immutable.hibernate.access.PersonRepository;
import com.blogspot.jpdevelopment.immutable.hibernate.access.domain.Person;
import com.blogspot.jpdevelopment.immutable.hibernate.configuration.Application;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Application.class);

		PersonRepository accessRepository = ctx.getBean(PersonRepository.class);

		Person person = new Person("J", "P");
		accessRepository.save(person);

		Person storedPerson = accessRepository.findOne(person.getId());

		System.out.println(storedPerson);
		ctx.close();
	}

}
