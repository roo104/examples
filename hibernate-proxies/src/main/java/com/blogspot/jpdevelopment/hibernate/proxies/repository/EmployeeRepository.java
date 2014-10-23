package com.blogspot.jpdevelopment.hibernate.proxies.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blogspot.jpdevelopment.hibernate.proxies.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, UUID> {

}
