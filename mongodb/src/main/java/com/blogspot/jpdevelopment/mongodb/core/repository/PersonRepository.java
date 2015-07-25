package com.blogspot.jpdevelopment.mongodb.core.repository;

import com.blogspot.jpdevelopment.mongodb.core.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class PersonRepository {

	private static final String PERSON_COLLENCTION = "person";

	@Autowired
	private MongoTemplate template;

	public Person findOne(UUID id) {
		CriteriaDefinition criteriaDefinition = Criteria.where("id").is(id);
		Query query = new Query();
		query.addCriteria(criteriaDefinition);
		return this.template.findOne(query, Person.class, PERSON_COLLENCTION);
	}

	public Person save(Person person) {
        this.template.save(person);
		return person;
	}


}
