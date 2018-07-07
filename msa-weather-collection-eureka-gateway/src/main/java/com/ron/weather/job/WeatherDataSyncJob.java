package com.ron.weather.job;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.ron.weather.entity.City;
import com.ron.weather.facade.WeatherDataCollectionFacade;
import com.ron.weather.service.CityFacade;

/**
 * Weather Data Sync Job.
 */
public class WeatherDataSyncJob extends QuartzJobBean {
	
	private static final Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);  

	@Autowired
	private WeatherDataCollectionFacade weatherDataCollectionService;
	
	@Autowired
	private CityFacade cityService;
	
	/* (non-Javadoc)
	 * @see org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org.quartz.JobExecutionContext)
	 */
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("Weather Data Sync Job. Start！");
		// 获取城市ID列表
		//改为由城市数据API微服务来提供数据
		List<City> cityList;
		try {
			cityList = cityService.listCity();
			// 遍历城市ID获取天气
			for (City city : cityList) {
				String cityId = city.getCityId();
				logger.info("Weather Data Sync Job, cityId:" + cityId);
				
				weatherDataCollectionService.syncDateByCityId(cityId);
			}
		} catch (Exception e) {
			logger.error("Error");
		}
		
		logger.info("Weather Data Sync Job. End！");
	}

}
