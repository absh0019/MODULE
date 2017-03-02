package io.egen.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;


@Entity
@NamedQueries({
	@NamedQuery(name="Weather.findAllCities", query="SELECT distinct w.city FROM WEATHER w"),
	@NamedQuery(name="Weather.latestWeather", query="SELECT w FROM WEATHER w WHERE where w.city=:tempcity ORDER BY w.date_Time DESC"),
	@NamedQuery(name="Weather.avgTemprature", query="SELECT avg(w.temperature) FROM WEATHER w WHERE w.city=:tempcity order by w.date_Time"),
})
public class Weather {

	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private String id;
	
	@Column (name = "CITY")
	private String city;
	
	@Column (name = "DISCRIPTION")
	private String discription;
	
	@Column (name = "HUMIDITY")
	private String humidity;
	
	@Column (name = "PRESSURE")
	private String pressure;
	
	@Column (name = "TEMPERATURE")
	private String temperature;
	
	@Column(name = "DATE_TIME", unique = true)
	private String date_Time;
	
	@OneToOne
	private Wind wind;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getDate_Time() {
		return date_Time;
	}

	public void setDate_Time(String date_Time) {
		this.date_Time = date_Time;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	
}
