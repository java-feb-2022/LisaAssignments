package com.codingdojo.week3.controllersPractice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/greeting")

public class HomeController {
	@RequestMapping("")
	public String index(){
		return "Hello user!";
	}
	// you can be explicit about the request as well
 	@RequestMapping(value="/hello", method=RequestMethod.GET)
 	public String hello(){
		return "Hello world! What route did you use to access me?";
 	}
 	@RequestMapping("/goodbye")
 	public String world(){
 		return "Goodbye world!";
 	}
}

