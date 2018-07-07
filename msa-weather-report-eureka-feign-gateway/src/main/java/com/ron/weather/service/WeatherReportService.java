package com.ron.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ron.weather.facade.WeatherReportFacade;
import com.ron.weather.vo.Weather;

/**
 * Weather Report Service.
 */
@Service
public class WeatherReportService implements WeatherReportFacade {
	
	@Autowired 
	private DataClient cityDataService;
	
	@Override
	public Weather getDataByCityId(String cityId) {
		//改为由天气数据API微服务来提供
		Weather data = cityDataService.getWeatherByCityId(cityId).getData();
		return data;
	}
}
