package com.lisa.ninjasdojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lisa.ninjasdojos.models.Dojo;
import com.lisa.ninjasdojos.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	 // returns all the dojos
    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }
    // creates a dojo
    public Dojo createDojo(Dojo b) {
        return dojoRepository.save(b);
    }
    // retrieves a dojo
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
    
    // updates the dojo
    public Dojo updateDojo(Dojo updatedDojo) {
    	return dojoRepository.save(updatedDojo);
    }
    
    public void deleteDojo(Long id) {
    	Optional<Dojo> deleteDojoAction = dojoRepository.findById(id);
    	if(deleteDojoAction.isPresent()) {
    		dojoRepository.deleteById(id);
    	} 
    	else {
    		System.out.println("Failed to delete");
    	}
    }
}
