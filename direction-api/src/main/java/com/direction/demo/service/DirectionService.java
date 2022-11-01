package com.direction.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.direction.demo.pojo.GoogleDirection;
import com.direction.demo.pojo.HereDirection;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@Service
public class DirectionService {
	@Autowired
	private Environment env;

	private RestTemplate restTemplate = new RestTemplate();

	public MappingJacksonValue getHereDirection() {

		String hereApi = env.getProperty("hereapi.url");

		HereDirection hereDirection = restTemplate.getForObject(hereApi, HereDirection.class);
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(hereDirection);

		FilterProvider filterProvider = new SimpleFilterProvider()
				.addFilter("RoutesFilter", SimpleBeanPropertyFilter.filterOutAllExcept("sections"))
				.addFilter("SectionFilter", SimpleBeanPropertyFilter.filterOutAllExcept("type", "polyline"));
		mappingJacksonValue.setFilters(filterProvider);

		return mappingJacksonValue;

	}

	public MappingJacksonValue getGoogleDirection() {
		String googleApi = env.getProperty("googleapi.url");

		GoogleDirection googleDirection = restTemplate.getForObject(googleApi, GoogleDirection.class);
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(googleDirection);

		FilterProvider filterProvider = new SimpleFilterProvider()
				.addFilter("RoutesFilter", SimpleBeanPropertyFilter.filterOutAllExcept("legs"))
				.addFilter("LegsFilter", SimpleBeanPropertyFilter.filterOutAllExcept("steps"))
				.addFilter("StepsFilter", SimpleBeanPropertyFilter.filterOutAllExcept("travel_mode", "polyline"));

		mappingJacksonValue.setFilters(filterProvider);

		return mappingJacksonValue;

	}

}
