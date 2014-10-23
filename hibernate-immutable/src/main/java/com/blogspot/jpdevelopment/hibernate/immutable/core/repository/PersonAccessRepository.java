package com.blogspot.jpdevelopment.hibernate.immutable.core.repository;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.blogspot.jpdevelopment.hibernate.immutable.core.domain.Person;


public class PersonAccessRepository implements PersonRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Person person) {
		this.entityManager.remove(person);

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
	public Iterable<Person> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Person> findAll(Iterable<UUID> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person findOne(UUID id) {
		return this.entityManager.find(Person.class, id);
	}

	@Transactional
	@Override
	public <S extends Person> S save(S person) {
		this.entityManager.persist(person);
		return person;
	}

	@Override
	public <S extends Person> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
