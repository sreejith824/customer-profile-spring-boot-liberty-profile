package com.tcs.mmisamples.customerprofile.service.impl;

import com.tcs.mmisamples.customerprofile.dao.CustomerProfilePaginationRepository;
import com.tcs.mmisamples.customerprofile.domain.CustomerProfile;
import com.tcs.mmisamples.customerprofile.service.CustomerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.Date;

/**
 * Created by SSasidharan on 2016/12/26.
 * Spring Service implementation class for Customer profile module.
 */
@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    @Autowired
    CustomerProfilePaginationRepository customerProfilePaginationRepository;

    @Autowired
    DataSource dataSource;

    public CustomerProfileServiceImpl() {

    }

    @PostConstruct
    public void loadData() {
        CustomerProfile customerProfile = null;
        for (int i=0 ; i < 1000; i++) {
            customerProfile = new CustomerProfile("Test : " + i %5, i%30);
            customerProfile.setProduct("Product : " + i%5);
            saveCustomerProfile(customerProfile);
        }
    }

    @Override
    @Transactional
    public Iterable<CustomerProfile> findAllCustomerProfiles(Pageable pageable) {
        Iterable<CustomerProfile> resultSet = customerProfilePaginationRepository.findAll(pageable);
        return resultSet;
    }

    @Override
    public CustomerProfile saveCustomerProfile(CustomerProfile customerProfile) {
        return customerProfilePaginationRepository.save(customerProfile);
    }

    @Override
    public Page<CustomerProfile> findCustomerProfileByName(String name, Pageable pageable) {
        return customerProfilePaginationRepository.findCustomerProfileByName(name, pageable);
    }

    @Override
    public CustomerProfile getCustomerProfile(int id) {
        return customerProfilePaginationRepository.findOne(id);
    }


}
