package com.example.Springbootexample.service;

import com.example.Springbootexample.dto.NewCustomerRequest;
import com.example.Springbootexample.entity.Customer;
import com.example.Springbootexample.exception.CustomerNotFound;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CustomerService {

    List<Customer> getCustomer();

    String addCustomer(NewCustomerRequest request);

    void deleteCustomer(Long customerId);

    void editCustomer(Long customerId, NewCustomerRequest request);

    Customer getCustomerByName(String customerName);

    Customer getCustomerById(Long customerId) throws CustomerNotFound;

}

