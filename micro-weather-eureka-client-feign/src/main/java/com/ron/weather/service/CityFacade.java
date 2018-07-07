package com.ron.weather.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("msa-weather-city-api-eureka")
public interface CityFacade {
	
	@GetMapping("/cities")
	String listCity();
}