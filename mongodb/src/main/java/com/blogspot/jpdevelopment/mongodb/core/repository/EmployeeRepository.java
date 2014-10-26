package com.blogspot.jpdevelopment.mongodb.core.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blogspot.jpdevelopment.mongodb.core.domain.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, UUID> {

}
