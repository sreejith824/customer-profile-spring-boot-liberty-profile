package com.tcs.mmisamples.customerprofile.config;

import com.tcs.mmisamples.customerprofile.scheduler.CustomerProfileScheduler;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Created by SSasidharan on 2017/01/03.
 * CORS configuration class for Spring MVC.
 */
@Configuration
public class CustomerProfileSchedulerConfig implements AsyncConfigurer {

    @Override
    @Bean
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(10);
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }

    @Bean
    @Lazy(value = false)
    CustomerProfileScheduler customerProfileScheduler() {
        return new CustomerProfileScheduler();
    }

}
