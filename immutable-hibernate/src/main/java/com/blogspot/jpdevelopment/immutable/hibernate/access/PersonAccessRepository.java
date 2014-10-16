package com.blogspot.jpdevelopment.immutable.hibernate.access;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blogspot.jpdevelopment.immutable.hibernate.access.domain.Person;

@Transactional
@Repository
public class PersonAccessRepository implements PersonRepository {

	//	@Autowired
	//	private SessionFactory sessionFactory;

	@PersistenceContext(name = "entityManagerFactory")
	private EntityManager entityManagerFactory;

	@Override
	public void storePerson(Person person) {
		this.entityManagerFactory.persist(person);
		//		this.sessionFactory.openSession().persist(person);
	}

	@Override
	public Person getPerson(UUID id) {
		return this.entityManagerFactory.find(Person.class, id);
	}
}
