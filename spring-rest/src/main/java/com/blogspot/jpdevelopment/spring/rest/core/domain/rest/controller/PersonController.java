package com.blogspot.jpdevelopment.spring.rest.core.domain.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blogspot.jpdevelopment.spring.rest.core.domain.rest.domain.Person;

@RestController
@RequestMapping("/rest/persons")
public class PersonController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Person> addPerson(@RequestBody Person person) {
		LOGGER.info("Received addPerson request: {}", person);

		return new ResponseEntity<Person>(person, HttpStatus.CREATED);
	}

}
