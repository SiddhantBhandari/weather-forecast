package com.weatherforecast.appconfig;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *  App Interceptor for intercepting requests without the mentioned header.
 *
 *
 * @author Siddhant Bhandari
 * @version 1.o
 * @since March 2023
 */
@Component
public class AppInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (request.getHeader("Accept") == null || !request.getHeader("Accept").contains("application/json")) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return false;
        }
        return true;
    }
}
