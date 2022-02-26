package com.lisa.week3.jsltags.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class FruitController {
	@RequestMapping("/")
	public String index(Model model) {
		
		model.addAttribute("fruit","banana");
		return "index.jsp";
		
	}
	@RequestMapping("/user")
	public String user(Model model) {
		
		String firstName="Ada";
		String lastName = "Lovelace";
		String email = "one@zeroes.com";
		Integer age = 160;
		
		model.addAttribute("first", firstName);
		model.addAttribute("last",lastName);
		model.addAttribute("email",email);
		model.addAttribute("age",age);
		
		return "user.jsp";
		
	}
}
