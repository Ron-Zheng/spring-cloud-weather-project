package com.ron.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ron.weather.facade.WeatherReportFacade;
import com.ron.weather.vo.Weather;
import com.ron.weather.vo.WeatherResponse;

@Service
public class WeatherReportService implements WeatherReportFacade {

	@Autowired
	private WeatherDataService  weatherDataService;
	
	@Override
	public Weather getDataByCityId(String cityId) {
		WeatherResponse resp = weatherDataService.getDataByCityId(cityId);
		return resp.getData();
	}
	
}
