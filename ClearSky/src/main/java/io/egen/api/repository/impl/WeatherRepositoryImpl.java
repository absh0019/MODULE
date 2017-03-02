package io.egen.api.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.egen.api.constants.WeatherProperty;
import io.egen.api.entity.Weather;
import io.egen.api.exception.BadRequestException;
import io.egen.api.repository.WeatherRepository;

public class WeatherRepositoryImpl implements WeatherRepository{

	@PersistenceContext
	private EntityManager em;

	@Override
	public List findAllCities() {
		Query query = em.createNamedQuery("Weather.findAllCities");
		return query.getResultList();
	}

	@Override
	public Weather findLatestWeatherForCity(String city) {
		
		TypedQuery<Weather> query = em.createNamedQuery("Weather.latestWeather", Weather.class);
		query.setParameter("tempcity", city);
		Weather latestWeather = query.getSingleResult();
		return latestWeather;
	}

	@Override
	public String findCityWeatherByProperty(String city, String property) {
		
		TypedQuery<Weather> query = em.createNamedQuery("Weather.latestWeather", Weather.class);
		query.setParameter("tempcity", city);
		Weather latestWeather = query.getSingleResult();
		WeatherProperty propertyObj = new WeatherProperty(property);
		try {
			return propertyObj.porpertyDetail(latestWeather);
		} catch (JsonProcessingException e) {
			throw new BadRequestException("cannot process the requested value");
		}
	}

	@Override
	public Double findCityHourlyAvgTemprature(String city) {
		Query query = em.createNamedQuery("Weather.avgTemprature");
		query.setParameter("tempcity", city).setMaxResults(60);
		return (Double)query.getSingleResult();
	}

	@Override
	public Double findCityDailyAvgTemprature(String city) {
		Query query = em.createNamedQuery("Weather.avgTemprature");
		query.setParameter("tempcity", city).setMaxResults(86400);
		return  (Double)query.getSingleResult();
	}
	
	
}
