package com.lisa.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lisa.relationships.models.License;
import com.lisa.relationships.repositories.LicenseRepository;
import com.lisa.relationships.repositories.PersonRepository;

@Service
public class LicenseService {
	
	
	@Autowired
	private LicenseRepository licenseRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	 // returns all the licenses
    public List<License> allLicenses() {
        return licenseRepository.findAll();
    }
    // creates a license
    public License createLicense(License b) {
        return licenseRepository.save(b);
    }
    // retrieves a license
    public License findLicense(Long id) {
        Optional<License> optionalLicense = licenseRepository.findById(id);
        if(optionalLicense.isPresent()) {
            return optionalLicense.get();
        } else {
            return null;
        }
    }
    
    // updates the license
    public License updateLicense(License updatedLicense) {
    	return licenseRepository.save(updatedLicense);
    }
    
    public void deleteLicense(Long id) {
    	Optional<License> deleteLicenseAction = licenseRepository.findById(id);
    	if(deleteLicenseAction.isPresent()) {
    		licenseRepository.deleteById(id);
    	} 
    	else {
    		System.out.println("Failed to delete");
    	}
    }
}
