package com.blogspot.jpdevelopment.hibernate.immutable.core.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blogspot.jpdevelopment.hibernate.immutable.config.HsqldbConfig;
import com.blogspot.jpdevelopment.hibernate.immutable.core.domain.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HsqldbConfig.class})
public class PersonAccessTest {

	@Autowired
	private PersonRepository classUnderTest;

	@Test
	public void persist() {
		Person person = new Person("J", "P");

		this.classUnderTest.save(person);
		Person personResult = this.classUnderTest.findOne(person.getId());

		assertNotNull(personResult);
	}

}
