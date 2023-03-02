package com.weatherforecast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 *
 * Weather Forecast Application
 *
 * @author Siddhant Bhandari
 * @version 1.0
 * @since March 2023
 */
@SpringBootApplication
public class WeatherForecastApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherForecastApplication.class, args);
		System.out.println("Application Started successfully");
	}

}
