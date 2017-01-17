package com.tcs.mmisamples.customerprofile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by SSasidharan on 2016/12/14.
 * Bootstrap class for Spring boot.
 */

@EnableJpaRepositories
@SpringBootApplication
public class CustomerProfileApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CustomerProfileApplication.class, args);
    }
}
