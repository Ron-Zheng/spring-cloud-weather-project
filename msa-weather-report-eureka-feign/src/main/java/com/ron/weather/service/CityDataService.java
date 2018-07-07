package com.ron.weather.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.ron.weather.vo.City;

@FeignClient("msa-weather-city-api-eureka")
public interface CityDataService {
	@GetMapping("/cities")
	List<City> listCity() throws Exception;
}
