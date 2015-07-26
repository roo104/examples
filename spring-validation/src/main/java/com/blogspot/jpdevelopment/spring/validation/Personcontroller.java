package com.blogspot.jpdevelopment.spring.validation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PersonController {

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new PersonValidator());
    }

    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    public ResponseEntity<Person> addPerson(@Valid @RequestBody Person person) {

        System.out.println(person.getFullName());

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public ResponseEntity<Person> addPerson() {

        return new ResponseEntity<>(new Person("Jonas", "Pedersen", 35), HttpStatus.OK);
    }
}
