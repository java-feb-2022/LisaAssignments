package com.lisa.forms.controllers;
	
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

import org.springframework.stereotype.Controller;

@Controller
public class MainController {
	@RequestMapping("/")
		public String index() {
			return "index.jsp";
	}		

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(
		@RequestParam(value="email") String email,
    	@RequestParam(value="password") String password) {
	    
    	// CODE TO PROCESS FORM ie. check email and password
	    	
	    	return "redirect:/dashboard"; // <-- we'll change this when we learn redirecting
	}
	
	@RequestMapping(value="/processPayment", method=RequestMethod.POST)
	public String processPayment(
	    @RequestParam(value="creditCardNumber") Integer creditCardNumber,
	    @RequestParam(value="expDate") Date expDate,
	    @RequestParam(value="productID") Integer productID) {
	    
	    // Code here to get the product price,
	    // Call to payment API
	    // complete the transaction and charge CC
	    System.out.printf("Charging credit, timestamp: %s", new Date());
	        
	    return "confirmationPage.jsp"; // <-- BAD
	    // Refresh the browser and it runs this method again :(
	}
	
	@RequestMapping("/confirm")
	public String confirmationPage(Model model){
	    
	    // get any info needed out of session and add to the
	    // view model to render on the page.
	        
	    return "confirmation.jsp";
	}
}

//ALTERNATIVELY
// @PostMapping("/users")
// public String login() {

//@GetMapping("/users")
//public String login() {
