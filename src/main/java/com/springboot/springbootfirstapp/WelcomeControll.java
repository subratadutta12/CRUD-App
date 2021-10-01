package com.springboot.springbootfirstapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeControll {
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome here!!!!";
	}
}
