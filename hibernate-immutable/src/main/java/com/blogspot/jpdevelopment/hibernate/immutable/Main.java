package com.blogspot.jpdevelopment.hibernate.immutable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.blogspot.jpdevelopment.hibernate.immutable.config.JpaConfig;
import com.blogspot.jpdevelopment.hibernate.immutable.core.domain.Person;
import com.blogspot.jpdevelopment.hibernate.immutable.core.repository.PersonRepository;

public class Main {

	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfig.class);

		PersonRepository accessRepository = ctx.getBean(PersonRepository.class);

		Person person = new Person("J", "P");
		accessRepository.save(person);

		Person storedPerson = accessRepository.findOne(person.getId());

		LOGGER.info("Stored person: {}", storedPerson);
		ctx.close();
	}

}
