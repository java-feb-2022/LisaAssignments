package com.lisa.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lisa.languages.models.Language;

@Repository // connection to the database
public interface LanguageRepository extends CrudRepository<Language, Long>{
	
    // this method retrieves all the languages from the database
    List<Language> findAll();

}