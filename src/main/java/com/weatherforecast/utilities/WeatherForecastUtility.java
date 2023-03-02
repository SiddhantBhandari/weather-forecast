package com.weatherforecast.utilities;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;


/**
 * Utility class for additional business logic for weather forecast APIs.
 *
 * @author Siddhant Bhandari
 * @version 1.0
 * @since March 2023
 */
@Service
public class WeatherForecastUtility {

    @Value("${rapid-api-base-uri}")
    private String rapidApiBaseUri;

    @Value("${rapid-api-key}")
    private String rapidApiKey;

    @Value("${rapid-api-host}")
    private String rapidApiHost;

    public Map<String, Object> getHourlyForecastSummaryByLocation(String locationName) throws IOException, InterruptedException {
        // Making request to rapid-api along with applicable headers.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(rapidApiBaseUri + locationName + "/hourly/"))
                .header("X-RapidAPI-Key", rapidApiKey)
                .header("X-RapidAPI-Host", rapidApiHost)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        // Fetching response
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return new JSONObject(response.body()).toMap();
    }

    public Map<String, Object> getForecastSummaryByLocation(String locationName) throws IOException, InterruptedException {
        // Making request to rapid-api along with applicable headers.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(rapidApiBaseUri + locationName + "/summary/"))
                .header("X-RapidAPI-Key", rapidApiKey)
                .header("X-RapidAPI-Host", rapidApiHost)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        // Fetching response
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return new JSONObject(response.body()).toMap();
    }
}
