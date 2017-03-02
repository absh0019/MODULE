package io.egen.api.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import io.egen.api.entity.Weather;
import io.egen.api.repository.WeatherRepository;
import io.egen.api.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService{
	
	private WeatherRepository weatherRepository;
	
	@Override
	public List findAllCities() {
		return weatherRepository.findAllCities();
	}

	@Override
	public Weather findLatestWeatherForCity(String city) {
		return weatherRepository.findLatestWeatherForCity(city);
	}

	@Override
	public String findCityWeatherByProperty(String city, String property) {
		return weatherRepository.findCityWeatherByProperty(city, property);
	}

	@Override
	public Double findCityHourlyAvgTemprature(String city) {
		return weatherRepository.findCityHourlyAvgTemprature(city);
	}

	@Override
	public Double findCityDailyAvgTemprature(String city) {
		return weatherRepository.findCityDailyAvgTemprature(city);
	}

	
	
}
