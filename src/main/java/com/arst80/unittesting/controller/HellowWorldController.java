package com.arst80.unittesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellowWorldController {
	
	@GetMapping("/hello-world")
	public String helloWorl() {
		return "Hello World";
	}

}
