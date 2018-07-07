package com.ron.weather.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ron.weather.facade.WeatherReportFacade;
import com.ron.weather.service.DataClient;
import com.ron.weather.vo.City;
/**
 * Weather Report Controller.
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {
	@Autowired
	private WeatherReportFacade weatherReportService;
	
	@Autowired 
	private DataClient cityDataService;
	
	@GetMapping("/cityId/{cityId}")
	public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
		// 获取城市ID列表
		// 改为由城市数据API微服务来提供数据
		List<City> cityList = cityDataService.listCity();

		model.addAttribute("title", "老卫的天气预报");
		model.addAttribute("cityId", cityId);
		model.addAttribute("cityList", cityList);
		model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
		return new ModelAndView("weather/report", "reportModel", model);
	}
}
