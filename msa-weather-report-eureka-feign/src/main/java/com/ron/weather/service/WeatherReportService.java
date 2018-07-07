package com.ron.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ron.weather.facade.WeatherReportFacade;
import com.ron.weather.vo.Weather;

/**
 * Weather Report Service.
 * 
 * @since 1.0.0 2017年11月26日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@Service
public class WeatherReportService implements WeatherReportFacade {
	
	@Autowired
	private WeatherDataService weatherDataService;
	
	@Override
	public Weather getDataByCityId(String cityId) {
		//改为由天气数据API微服务来提供
		Weather data = weatherDataService.getWeatherByCityId(cityId).getData();
		return data;
	}
}
