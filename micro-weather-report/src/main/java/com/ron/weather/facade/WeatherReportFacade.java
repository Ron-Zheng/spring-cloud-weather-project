package com.ron.weather.facade;

import com.ron.weather.vo.Weather;

public interface WeatherReportFacade {
	Weather getDataByCityId(String cityId);
}
