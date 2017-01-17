package com.tcs.mmisamples.customerprofile.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by SSasidharan on 2017/01/03.
 * CORS configuration class for Spring MVC.
 */
@Configuration
@EnableWebMvc

public class CustomerProfileWebMVCConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }


}
