package com.examplenew.cms.dao;

import com.examplenew.cms.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao extends CrudRepository<Customer , Integer> {
    @Override
    List<Customer> findAll();

}
