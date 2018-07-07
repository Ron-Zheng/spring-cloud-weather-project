package com.ron.weather.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ron.weather.vo.City;
import com.ron.weather.vo.WeatherResponse;

/**
 * 服务熔断实现类
 * @author Ron
 *
 */
@Component
public class DataClientFallback implements DataClient {
	
	/**
	 * 如果获取城市列表失败，则返回两个城市信息
	 */
	@Override
	public List<City> listCity() throws Exception {
		List<City> cityList = null;
		cityList = new ArrayList<>();
		
		City city = new City();
		city.setCityId("101280601");
		city.setCityName("深圳");
		cityList.add(city);
		
		city = new City();
		city.setCityId("101280301");
		city.setCityName("惠州");
		cityList.add(city);
		
		return cityList;
	}

	@Override
	public WeatherResponse getWeatherByCityId(String cityId) {
		return null;
	}

	@Override
	public WeatherResponse getWeatherByCityName(String cityName) {
		return null;
	}
}
