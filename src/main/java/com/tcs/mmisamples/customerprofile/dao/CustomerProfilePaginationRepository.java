package com.tcs.mmisamples.customerprofile.dao;

import com.tcs.mmisamples.customerprofile.domain.CustomerProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by SSasidharan on 2016/12/26.
 * Data access layer (Repository) interface with Pagination features.
 */

@Repository
public interface CustomerProfilePaginationRepository extends PagingAndSortingRepository<CustomerProfile, Integer> {
    Page<CustomerProfile> findCustomerProfileByName(String name, Pageable pageable);
}
