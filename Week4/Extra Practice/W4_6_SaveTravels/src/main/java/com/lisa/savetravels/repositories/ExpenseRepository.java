package com.lisa.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lisa.savetravels.models.Expense;

@Repository // connection to the database
public interface ExpenseRepository extends CrudRepository<Expense, Long>{
	
    // this method retrieves all the expenses from the database
    List<Expense> findAll();
    
    // this method finds expenses with vendors containing the search string
    List<Expense> findByVendorContaining(String search);
    
    // this method counts how many expDescriptions contain a certain string
    Long countByExpDescriptionContaining(String search);
    
    // this method deletes a expense that starts with a specific expDescription
    Long deleteByExpDesciptionStartingWith(String search);

}