package com.weatherforecast.exceptions;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * Model class for error response
 *
 *
 * @author Siddhant Bhandari
 * @version 1.0
 * @since March 2023
 */
public class ErrorResponse {

    private String message;

    private List<String> details = new ArrayList<>();

    public ErrorResponse(String message, List<String> details) {
        this.message = message;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getDetails() {
        return details;
    }
}
