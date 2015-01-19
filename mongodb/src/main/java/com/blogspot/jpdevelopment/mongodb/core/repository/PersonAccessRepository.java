package com.blogspot.jpdevelopment.mongodb.core.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.blogspot.jpdevelopment.mongodb.core.domain.Person;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PersonAccessRepository implements PersonRepository {

	private static final String PERSON_COLLENCTION = "person";

	@Autowired
	private MongoTemplate template;

	@Override
	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Person> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Person> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(UUID arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Person arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Person> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean exists(UUID arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Person> findAll(Iterable<UUID> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person findOne(UUID id) {
		CriteriaDefinition criteriaDefinition = Criteria.where("id").is(id);
		Query query = new Query();
		query.addCriteria(criteriaDefinition);
		return this.template.findOne(query, Person.class, PERSON_COLLENCTION);
	}

	@Override
	public <PERSON extends Person> PERSON save(PERSON person) {
		template.save(person);
		return person;
	}


}
