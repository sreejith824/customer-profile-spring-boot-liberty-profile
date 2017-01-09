package com.tcs.mmisamples.customerprofile.scheduler;

import com.tcs.mmisamples.customerprofile.service.CustomerProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SSasidharan on 2017/01/09.
 */
@Component
public class CustomerProfileScheduler {

    private static final Logger log = LoggerFactory.getLogger(CustomerProfileScheduler.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    CustomerProfileService customerProfileService;

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("The time is now {}" +  dateFormat.format(new Date()));
        customerProfileService.getCustomerProfile(1);
        System.out.println(customerProfileService.getCustomerProfile(1).getName());
    }

}
