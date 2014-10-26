package com.blogspot.jpdevelopment.mongodb.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.blogspot.jpdevelopment.mongodb.core.domain.Department;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {

}
