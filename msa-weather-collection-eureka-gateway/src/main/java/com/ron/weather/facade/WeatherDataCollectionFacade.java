package com.ron.weather.facade;

public interface WeatherDataCollectionFacade {
	/**
	 * 根据城市ID同步天气
	 * @param cityId
	 */
	void syncDateByCityId(String cityId);
}
