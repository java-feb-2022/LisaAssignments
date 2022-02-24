package com.codingdojo.week3.queryParameters;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("query")

public class HomeController {
	
    @RequestMapping("/")
    public String index(@RequestParam(value="q", required=false) String searchQuery) {
    	if(searchQuery == null) {
    		return "Your search returned nothing";
    		// your search was http://localhost:8080/query/?
    	} else {
        return "You searched for: " + searchQuery;
        //search by http://localhost:8080/query/?q=Lisa
    	}
    }
}