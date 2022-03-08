package com.lisa.fullcrudsavetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lisa.fullcrudsavetravels.models.Expense;
import com.lisa.fullcrudsavetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	 // returns all the expenses
    public List<Expense> allExpenses() {
        return expenseRepository.findAll();
    }
    // creates a expense
    public Expense createExpense(Expense b) {
        return expenseRepository.save(b);
    }
    // retrieves a expense
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
    
    // updates the expense
    public Expense updateExpense(Expense updatedExpense) {
    	return expenseRepository.save(updatedExpense);
    }
    
    public void deleteExpense(Long id) {
    	Optional<Expense> deleteExpenseAction = expenseRepository.findById(id);
    	if(deleteExpenseAction.isPresent()) {
    		expenseRepository.deleteById(id);
    	} 
    	else {
    		System.out.println("Failed to delete");
    	}
    }
}
