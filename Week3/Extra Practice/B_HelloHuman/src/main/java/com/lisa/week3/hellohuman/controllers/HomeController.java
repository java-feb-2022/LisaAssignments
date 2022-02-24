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
		String result;
//		StringBuilder disp = new StringBuilder();
		String disp = "";
		
		if (times == null) {
			result = greeting;
		} else {
			for (int i = 1; i<=times; i++) {
				disp = disp + greeting;
			}
		}	
		return disp;

		}
	}

//
//    @RequestMapping("/")
//    public String index(@RequestParam(value="q", required=false) String searchQuery) {
//    	if(searchQuery == null) {
//    		return "Your search returned nothing";
//    		// your search was http://localhost:8080/query/?
//    	} else {
//        return "You searched for: " + searchQuery;
//        //search by http://localhost:8080/query/?q=Lisa
//    	}
//    }
//}