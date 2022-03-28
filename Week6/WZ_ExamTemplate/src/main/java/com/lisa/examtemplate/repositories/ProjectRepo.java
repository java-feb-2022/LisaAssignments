package com.lisa.examtemplate.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lisa.examtemplate.models.Project;


// All the business logic  - writing codes to interact with your database.
@Repository
public interface ProjectRepo extends CrudRepository<Project, Long>{
	
	List<Project> findAll();
	}
