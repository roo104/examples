package com.blogspot.jpdevelopment.spring.rest.core.domain.rest.controller;

import com.blogspot.jpdevelopment.mongodb.core.domain.Person;
import com.blogspot.jpdevelopment.mongodb.core.repository.PersonRepository;
import com.blogspot.jpdevelopment.spring.rest.core.domain.rest.domain.NoDataFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blogspot.jpdevelopment.spring.rest.core.domain.rest.domain.RestPerson;

import java.util.UUID;

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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<RestPerson> getPerson(@PathVariable String id) throws NoDataFoundException {
		Person person = personRepository.findOne(UUID.fromString(id));
		if (person == null) {
			throw new NoDataFoundException(String.format("No person with ID [%s] found", id.toString()));
		}
		return new ResponseEntity<RestPerson>(RestPerson.fromPerson(person), HttpStatus.OK);
	}

}
