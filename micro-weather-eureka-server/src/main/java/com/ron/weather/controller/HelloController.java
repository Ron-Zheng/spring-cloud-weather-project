package com.ron.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Hello Controller.
 */
@RestController
public class HelloController {
	@GetMapping("/hello")
	public String hello() {
		return "Hello World!";
	}
}
