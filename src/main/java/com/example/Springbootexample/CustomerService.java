package com.example.Springbootexample;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CustomerService {

    List<Customer> getCustomer();

    String addCustomer(NewCustomerRequest request);

    void deleteCustomer(Long customerId);

    void editCustomer(Long customerId, NewCustomerRequest request);
}
