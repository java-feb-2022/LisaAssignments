package com.lisa.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lisa.relationships.models.Person;
import com.lisa.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	
	
	@Autowired
	private PersonRepository personRepository;
	
	 // returns all the persons
    public List<Person> allPersons() {
        return personRepository.findAll();
    }
    // creates a person
    public Person createPerson(Person b) {
        return personRepository.save(b);
    }
    // retrieves a person
    public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
    }
    
    // updates the person
    public Person updatePerson(Person updatedPerson) {
    	return personRepository.save(updatedPerson);
    }
    
    public void deletePerson(Long id) {
    	Optional<Person> deletePersonAction = personRepository.findById(id);
    	if(deletePersonAction.isPresent()) {
    		personRepository.deleteById(id);
    	} 
    	else {
    		System.out.println("Failed to delete");
    	}
    }
}
