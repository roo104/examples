package com.blogspot.jpdevelopment.spring.transaction.dao.impl;

import com.blogspot.jpdevelopment.spring.transaction.dao.TestDAO;
import com.blogspot.jpdevelopment.spring.transaction.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TestDAOImpl implements TestDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertUser(User user) {
        this.entityManager.persist(user);
	}

	@Override
	public User fetchUser(int id) {
		return this.entityManager.find(User.class, id);
	}

}
