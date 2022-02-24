package com.lisa.week3.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController

public class HomeController {
	
	@RequestMapping("/")
	public String index(
			@RequestParam(required=false) String fname, 
			@RequestParam(required=false) String lname, 
			@RequestParam(required=false) Integer times) {
		String greeting = "Hello " + fname +" "+ lname+" ";
		String result = "";
		
		if (times == null) {
			result = greeting;
		} else {
			for (int i = 1; i<=times; i++) {
				result = result + greeting;
			}
		}	
		return result;

		}
	}