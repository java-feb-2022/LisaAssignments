package com.lisa.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lisa.relationships.models.License;

@Repository // connection to the database
public interface LicenseRepository extends CrudRepository<License, Long>{
	
    // this method retrieves all the licenses from the database
    List<License> findAll();

}