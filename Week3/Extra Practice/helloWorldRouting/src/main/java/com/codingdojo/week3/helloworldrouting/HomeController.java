package com.codingdojo.week3.helloworldrouting;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class HomeController {
	@RequestMapping("/") 
	public String hello() {
		return "Hello World";
	}
	@RequestMapping("/new_route") 
	public String lisa() { 
		return "'tis Lisa";
	}
}
