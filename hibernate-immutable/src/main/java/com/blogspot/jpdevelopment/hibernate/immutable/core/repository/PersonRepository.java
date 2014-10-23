package com.blogspot.jpdevelopment.hibernate.immutable.core.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blogspot.jpdevelopment.hibernate.immutable.core.domain.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, UUID> {
}
