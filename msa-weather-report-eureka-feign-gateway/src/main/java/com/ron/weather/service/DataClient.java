package com.ron.weather.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ron.weather.vo.City;
import com.ron.weather.vo.WeatherResponse;

@FeignClient("msa-weather-eureka-client-zuul")
public interface DataClient {
	@GetMapping("/city/cities")
	List<City> listCity() throws Exception;
	
	@GetMapping("/data/weather/cityId/{cityId}")
	WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId);
	
	@GetMapping("/data/weather/cityName/{cityName}")
	WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName);
}
