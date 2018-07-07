package com.ron.weather.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.ron.weather.facade.CityDataFacade;
import com.ron.weather.utils.XmlBuilder;
import com.ron.weather.vo.City;
import com.ron.weather.vo.CityList;

@Service
public class CityDataService implements CityDataFacade {

	@Override
	public List<City> listCity() throws Exception {
		// 读取XML文件
		Resource resource = new ClassPathResource("citylist.xml");
		BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		
		while ((line = br.readLine()) !=null) {
			buffer.append(line);
		}
		
		br.close();
		
		// XML转为Java对象
		CityList cityList = (CityList)XmlBuilder.xmlStrToOject(CityList.class, buffer.toString());
		return cityList.getCityList();
	}
}