package com.blogspot.jpdevelopment.mongodb.core.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blogspot.jpdevelopment.mongodb.core.domain.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person, UUID> {

}
