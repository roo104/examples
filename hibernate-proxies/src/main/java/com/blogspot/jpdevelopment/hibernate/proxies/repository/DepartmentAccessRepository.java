package com.blogspot.jpdevelopment.hibernate.proxies.repository;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.blogspot.jpdevelopment.hibernate.proxies.domain.Department;

public class DepartmentAccessRepository implements DepartmentRepository {

	@PersistenceContext
	private EntityManager entityManager;

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
	public void delete(Department arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Iterable<? extends Department> arg0) {
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
	public Iterable<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Department> findAll(Iterable<UUID> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department findOne(UUID arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Department> S save(S employee) {
		this.entityManager.persist(employee);
		return employee;
	}

	@Override
	public <S extends Department> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
