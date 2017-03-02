package io.egen.api.service;

import java.util.List;

import io.egen.api.entity.Weather;

public interface WeatherService {
	
	public List<String> findAllCities();

	public Weather findLatestWeatherForCity(String city);
	
	public String findCityWeatherByProperty(String city, String property);

	public Double findCityHourlyAvgTemprature(String city);
	
	public Double findCityDailyAvgTemprature(String city);
	
}
