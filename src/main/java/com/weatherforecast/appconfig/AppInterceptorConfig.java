package com.weatherforecast.appconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 *
 * Configuration class for registering the interceptor.
 *
 * @author Siddhant Bhandari
 * @version 1.0
 * @since March 2023
 */
@Configuration
public class AppInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private AppInterceptor appInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(appInterceptor);
    }
}
