package com.ashhar.rest.webservices.restful_web_services.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World!";
	}
	
	// return a HelloWorld Spring Bean
	@GetMapping("/hello-world-bean/{message}")
	public HelloWorldBean helloWorldBean(@PathVariable String message) {
		return new HelloWorldBean(String.format("Hello World!, %s", message));
	}
	
	
	
}
