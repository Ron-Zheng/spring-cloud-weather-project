package com.ron.weather.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ron.weather.vo.WeatherResponse;

@FeignClient("msa-weather-data-api-eureka")
public interface WeatherDataService {
	
	@GetMapping("/weather/cityId/{cityId}")
	WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId);
	
	@GetMapping("/weather/cityName/{cityName}")
	WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName);
}