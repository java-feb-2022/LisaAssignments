package com.lisa.week3.daikichipathvariables.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("daikichi")

public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "This is the home page. Navigate to a different site";
	}
	
	@RequestMapping("/{action}/{location}")
	public String congrats(
			@PathVariable("action") String action,
			@PathVariable("location") String location) {
		return "Congratulations! You will soon " + action + " to " + location + "!";
	}
	
	@RequestMapping("/lotto/{integer}")
	public String fortune(
			@PathVariable("integer") Integer integer) {
		if(integer%2 == 0) {
			return "You will take a grand journey in the near future, but be wary of tempting offers";			
		} else {
			return "You have enjoyed the fruits of your labor, but now is a great time to spend time with family and friends.";			
		}
	}
}