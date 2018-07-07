package com.ron.weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ron.weather.facade.CityDataFacade;
import com.ron.weather.vo.City;
/**
 * Hello Controller.
 * 
 * @since 1.0.0 2017年11月20日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@RestController
@RequestMapping("/cities")
public class CityController {
	
	@Autowired
	private CityDataFacade cityDataService;
	
	@GetMapping
	public List<City> listCity() throws Exception {
		return cityDataService.listCity();
	}
}
