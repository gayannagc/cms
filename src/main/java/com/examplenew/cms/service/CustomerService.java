package com.examplenew.cms.service;

import com.examplenew.cms.dao.CustomerDao;
import com.examplenew.cms.exception.CustomerNotFoundException;
import com.examplenew.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    /*private int customerIdCount=1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();*/

    public Customer addCustomer(Customer customer){
        /*customer.setCustomerId(customerIdCount);
        customerList.add(customer);
        customerIdCount++;
        return customer;*/
        return customerDao.save(customer);
    }

    public List getCustomers(){
        return customerDao.findAll();
        //return customerList;
    }

    public Customer getCustomer(int customerId){
        /*return customerList
                .stream()
                .filter(customer -> customer.getCustomerId() == customerId)
                .findFirst()
                .get();*/
        Optional<Customer> optionalCustomer = customerDao.findById(customerId);
        if (!optionalCustomer.isPresent()){
            throw new CustomerNotFoundException("Customer Not Found");
        }
        return optionalCustomer.get();
    }

    public Customer updateCustomer(int customerId, Customer customer){
        /*customerList
                .stream()
                .forEach(c -> {
                    if (c.getCustomerId() == customerId){
                        c.setCustomerFirstName(customer.getCustomerFirstName());
                        c.setCustomerLastName(customer.getCustomerLastName());
                        c.setCustomerEmail(customer.getCustomerEmail());
                    }
                });
        return customerList.stream()
                .filter(c -> c.getCustomerId() == customerId )
                .findFirst()
                .get();*/

        customer.setCustomerId(customerId);
        return customerDao.save(customer);

    }

    public void removeCustomer(int customerId){
        /*customerList.stream()
                .forEach(customer -> {
                    if (customer.getCustomerId() == customerId){
                        customerList.remove(customer);
                    }
                });*/
        customerDao.deleteById(customerId);


    }



}
