package io.egen.api.constants;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.egen.api.entity.Weather;
import io.egen.api.entity.Wind;

public class WeatherProperty {

	public enum Properties {
		CITY,DISCRIPTION,HUMIDITY, PRESSURE,TEMPERATURE,DATE_TIME,WIND,DEGREE,SPEED;
	}
	
	Properties property;
	
	
	public WeatherProperty (String property) {
	
		
		switch (property.toUpperCase()) {
				case "CITY":
					this.property = Properties.CITY;
				case "DISCRIPTION":
					this.property  = Properties.DISCRIPTION;
				case "HUMIDITY":
					this.property = Properties.HUMIDITY;
				case "PRESSURE":
					this.property = Properties.PRESSURE;
				case "TEMPERATURE":
					this.property = Properties.TEMPERATURE;
				case "WIND":
					this.property  = Properties.WIND;
				case "DEGREE":
					this.property = Properties.DEGREE;
				case "SPEED":
					this.property = Properties.SPEED;
				case "DATE_TIME":
					this.property = Properties.DATE_TIME;
				case "TIMESTAMP":
					this.property = Properties.DATE_TIME;
				default:
					this.property = null;
		}
		
	}
	
	public String porpertyDetail (Weather weather) throws JsonProcessingException  {
		
		switch (property) {
			
		case CITY:
			return String.valueOf(weather.getCity());
		case DISCRIPTION:
			return String.valueOf(weather.getDiscription());
		case HUMIDITY:
			return String.valueOf(weather.getHumidity());
		case PRESSURE:
			return String.valueOf(weather.getPressure());
		case TEMPERATURE:
			return String.valueOf(weather.getTemperature());
		case WIND:
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(weather.getWind());
		case DEGREE:
			Wind windDegree = weather.getWind();
			return String.valueOf(windDegree.getDegree());
		case SPEED:
			Wind windSpeed = weather.getWind();
			return String.valueOf(windSpeed.getSpeed());
		case DATE_TIME:
			return String.valueOf(weather.getDate_Time());
		default:
			return null;
		}
		
	}
}
