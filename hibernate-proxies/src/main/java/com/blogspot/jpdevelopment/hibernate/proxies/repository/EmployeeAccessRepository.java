package com.blogspot.jpdevelopment.hibernate.proxies.repository;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.blogspot.jpdevelopment.hibernate.proxies.domain.Employee;

public class EmployeeAccessRepository implements EmployeeRepository {

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
	public void delete(Employee arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Iterable<? extends Employee> arg0) {
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
	public Iterable<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Employee> findAll(Iterable<UUID> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findOne(UUID id) {
		return this.entityManager.find(Employee.class, id);
	}

	@Override
	public <S extends Employee> S save(S employee) {
		this.entityManager.persist(employee);
		return employee;
	}

	@Override
	public <S extends Employee> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
