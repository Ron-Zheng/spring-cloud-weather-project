package com.ron.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ron.weather.service.CityFacade;

@RestController
public class CityController {
	
	@Autowired
	private CityFacade cityService;
	
	@GetMapping("/cities")
	@HystrixCommand(fallbackMethod="defaultCities")
	public String listCity() {
		return cityService.listCity();
	}
	
	/**
	 * @return
	 */
	public String defaultCities() {
		return "City Data Server is Down!";
	}
}