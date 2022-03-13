package com.lisa.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lisa.relationships.models.Person;

@Repository // connection to the database
public interface PersonRepository extends CrudRepository<Person, Long>{
	
    // this method retrieves all the persons from the database
    List<Person> findAll();
//
//    Optional<User> findById(Long Id);
//    
//    boolean existsById(Long Id);
//    Person findById(Long Id);
}