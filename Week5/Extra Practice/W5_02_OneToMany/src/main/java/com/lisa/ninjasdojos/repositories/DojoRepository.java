package com.lisa.ninjasdojos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lisa.ninjasdojos.models.Dojo;

@Repository // connection to the database
public interface DojoRepository extends CrudRepository<Dojo, Long>{
	
    // this method retrieves all the persons from the database
    List<Dojo> findAll();

}