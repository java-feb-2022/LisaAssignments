package com.lisa.fullcrudsavetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lisa.fullcrudsavetravels.models.Expense;

@Repository // connection to the database
public interface ExpenseRepository extends CrudRepository<Expense, Long>{
	
    // this method retrieves all the expenses from the database
    List<Expense> findAll();

}