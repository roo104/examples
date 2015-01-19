package com.blogspot.jpdevelopment.spring.rest.core.domain.rest.controller;

import com.blogspot.jpdevelopment.mongodb.core.domain.Person;
import com.blogspot.jpdevelopment.mongodb.core.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blogspot.jpdevelopment.spring.rest.core.domain.rest.domain.RestPerson;

@RestController
@RequestMapping("/rest/persons")
public class PersonController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private PersonRepository personRepository;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<RestPerson> addPerson(@RequestBody RestPerson restPerson) {
		LOGGER.info("Received addPerson request: {}", restPerson);
		Person person = personRepository.save(restPerson.toPersion());
		return new ResponseEntity<RestPerson>(RestPerson.fromPerson(person), HttpStatus.CREATED);
	}

}
