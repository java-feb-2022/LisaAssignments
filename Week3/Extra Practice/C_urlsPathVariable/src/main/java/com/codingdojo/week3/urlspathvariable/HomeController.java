package com.codingdojo.week3.urlspathvariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("path")

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
    @RequestMapping("/m/{track}/{module}/{lesson}")
    public String showLesson(
    		@PathVariable("track") String track, 
    		@PathVariable("module") String module, 
    		@PathVariable("lesson") String lesson) {
    	return "Track: " + track + ", Module: " + module + ", Lesson: " + lesson;
    }
}