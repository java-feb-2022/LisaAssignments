// main entry point for your application
package com.codingdojo.week3.helloworldrouting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController //allows this class to respond as a controller
public class HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

	@RequestMapping("/") //allows me to respond to the root request
	public String hello() { //method that will respond to the root route and return a message saying "hello world
		return "Hello World";
	}
	@RequestMapping("/new_route") //allows me to respond to the root request
	public String lisa() { //method that will respond to the root route and return a message saying "hello world
		return "'tis Lisa";
	}
}
