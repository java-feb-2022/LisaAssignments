package com.lisa.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.lisa.savetravels.models.Expense;
import com.lisa.savetravels.services.ExpenseService;

@Controller //Controller will return a jsp page
public class ExpenseController {
	
	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/expenses")
	public String index(Model model, @ModelAttribute("expense") Expense expense) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("allExpenses",expenses);
		return "index.jsp";
	}
	
//	@GetMapping("/expenses/new")
//	public String newExpense(@ModelAttribute("expense") Expense expense) {
//		return "new.jsp";
//	}
 
	@PostMapping("/expenses")
	public String create(
			@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) {
//			return "new.jsp";
			return "index.jsp";
			} else {
				expenseService.createExpense(expense);
				return "redirect:/expenses";				
			}
	}
 
	 @GetMapping("/expenses/{id}")
	 public String show(Model model, @PathVariable("id") Long id) {
		 Expense expense = expenseService.findExpense(id);
		 model.addAttribute("showExpense",expense);
		 return "show.jsp";
	 }
	 
    @GetMapping("/expenses/edit/{id}")
	 public String edit(Model model, @PathVariable("id") Long id) {
		 Expense expense = expenseService.findExpense(id);
		 model.addAttribute("editExpense",expense);
        return "edit.jsp";
    }
    
    @PutMapping("/expenses/{id}")
    public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            expenseService.updateExpense(expense);
            return "redirect:/expenses";
        }
    }
 
// @RequestMapping(value="/expenses/{id}", method=RequestMethod.DELETE)
// public void destroy(@PathVariable("id") Long id) {
//     expenseService.deleteExpense(id); 
// }
}
