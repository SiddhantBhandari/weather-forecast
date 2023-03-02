package com.weatherforecast.controllers;


import com.weatherforecast.utilities.WeatherForecastUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import java.util.Map;


/**
 *
 *  REST controller for weather forecast API calls
 *
 *
 * @author Siddhant Bhandari
 * @version 1.0
 * @since March 2023
 *
 */
@RestController
@RequestMapping(path = "/forecast")
public class WeatherForecastController {


    @Autowired
    private WeatherForecastUtility weatherForecastUtility;

    @GetMapping("/")
    public String home(@RequestHeader(name = "Client-ID", required = true) String clientId,
                       @RequestHeader(name = "Client-Secret", required = true) String clientSecret){
        return "Hello!";
    }

    @GetMapping("/summary/{locationName}")
    public ResponseEntity<Map<String, Object>> getWeatherForecastDetails(
            @RequestHeader(name = "Client-ID", required = true) String clientId,
            @RequestHeader(name = "Client-Secret", required = true) String clientSecret,
            @PathVariable("locationName") String locationName){
        Map<String, Object> forecastSummaryByLocation;
        try {
            forecastSummaryByLocation = weatherForecastUtility.getForecastSummaryByLocation(locationName);
        } catch (IOException | InterruptedException e) {
           throw new RuntimeException(e);
       }
       return ResponseEntity.ok(forecastSummaryByLocation);
    }

    @GetMapping("/hourly-summary/{locationName}")
    public ResponseEntity<Map<String, Object>> getHourlyWeatherForecastDetails(
            @RequestHeader(name = "Client-ID", required = true) String clientId,
            @RequestHeader(name = "Client-Secret", required = true) String clientSecret,
            @PathVariable("locationName") String locationName){
        Map<String, Object> forecastSummaryByLocation;
        try {
            forecastSummaryByLocation = weatherForecastUtility.getHourlyForecastSummaryByLocation(locationName);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(forecastSummaryByLocation);
    }
}
