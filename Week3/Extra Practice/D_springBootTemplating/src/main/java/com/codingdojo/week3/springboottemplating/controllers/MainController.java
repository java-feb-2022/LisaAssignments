package com.codingdojo.week3.springboottemplating.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class MainController {
	
	@RequestMapping("/")
	public String index() {
		return "<h1 style='color: purple;'> Hello world <h1>";
	}
}
