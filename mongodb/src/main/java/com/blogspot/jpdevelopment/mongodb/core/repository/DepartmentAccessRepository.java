package com.blogspot.jpdevelopment.mongodb.core.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.blogspot.jpdevelopment.mongodb.core.domain.Department;

@Repository
public class DepartmentAccessRepository implements DepartmentRepository {

	private static final String DEPARTMENT_COLLENCTION = "department";

	@Autowired
	private MongoTemplate template;

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Department> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Department> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String arg0) {
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
	public boolean exists(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Department> findAll(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department findOne(String name) {
		CriteriaDefinition criteriaDefinition = Criteria.where("name").is(name);
		Query query = new Query();
		query.addCriteria(criteriaDefinition);
		return this.template.findOne(query, Department.class, DEPARTMENT_COLLENCTION);
	}

	@Override
	public <S extends Department> S save(S department) {
		this.template.save(department, DEPARTMENT_COLLENCTION);
		return department;
	}


}
