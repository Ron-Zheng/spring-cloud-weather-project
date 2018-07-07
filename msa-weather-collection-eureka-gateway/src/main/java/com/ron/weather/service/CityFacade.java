package com.ron.weather.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.ron.weather.entity.City;

@FeignClient("msa-weather-eureka-client-zuul")
public interface CityFacade {
	@GetMapping("/city/cities")
	List<City> listCity() throws Exception;
}