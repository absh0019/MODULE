package io.egen.api.controller;


import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.egen.api.constants.URI;
import io.egen.api.entity.Weather;
import io.egen.api.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = URI.WEATHER)
@Api(tags = "weather")
public class WeatherController {

	
	private WeatherService weatherService;

	public WeatherController(WeatherService weatherService ) {
		this.weatherService = weatherService;
	}

	//returns list of cities with data
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Find Weather for City", notes = "Returns a list with weather details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
	@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List findAllCities() {
		
		List weatherList = weatherService.findAllCities();
		
		return weatherList;
	}

	//return latest weather for a city
	@RequestMapping(method = RequestMethod.GET, value = URI.CITYWEATHER)
	@ApiOperation(value = "Find Weather Property", notes = "Returns details for a weather property")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"), 
							@ApiResponse(code = 404, message = "Not Found"),
							@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Weather findCityProperty(@PathVariable("city") String city) {
		return weatherService.findLatestWeatherForCity(city);
	}
	
	//returns weather property
	@RequestMapping(method = RequestMethod.GET, value = URI.CITYPROPERTY)
	@ApiOperation(value = "Find Weather Property", notes = "Returns details for a weather property")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"), 
							@ApiResponse(code = 404, message = "Not Found"),
							@ApiResponse(code = 500, message = "Internal Server Error"), })
	public String findCityProperty(@PathVariable("city") String city, 
									@PathVariable("property") String property) {
		return weatherService.findCityWeatherByProperty(city, property);
	}

	//returns hourly average for a city
	@RequestMapping(method = RequestMethod.GET, value = URI.CITYHOURLY)
	@ApiOperation(value = "Find hourly average temperature", notes = "Returns hourly temperature for a given city")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Double findCityHourlyAvgTemprature(@PathVariable("city") String city) {
		return weatherService.findCityHourlyAvgTemprature(city);
	}
	
	//returns daily average for a city
	@RequestMapping(method = RequestMethod.GET, value = URI.CITYDAILY)
	@ApiOperation(value = "Find User by Id", notes = "Returns a user by id if it exists in the app")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Double findCityDailyAvgTemprature(@PathVariable("city") String city) {
		return weatherService.findCityDailyAvgTemprature(city);
	}
	
	
}