package com.example.Springbootexample.controller;

import com.example.Springbootexample.dto.NewCustomerRequest;
import com.example.Springbootexample.entity.Customer;
import com.example.Springbootexample.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getCustomer")
  public ResponseEntity<List<Customer>> getCustomers(){
        List<Customer> allCustomers = customerService.getCustomer();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }


    @PostMapping("/addCustomer")
    public ResponseEntity<String> addCustomer(@RequestBody NewCustomerRequest request){
        customerService.addCustomer(request);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteCustomer/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("customerId") Long customerId){
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>("Customer Deleted", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/editCustomer/{customerId}")
    public ResponseEntity<String> editCustomer(@PathVariable("customerId") Long customerId, @RequestBody  NewCustomerRequest request){
        customerService.editCustomer(customerId,request);
        return new ResponseEntity<>("Customer has been Updated", HttpStatus.OK);
    }
    @GetMapping("/getCustomer/name/{name}")
    public Customer getCustomerByName(@PathVariable("name") String customerName){
        return customerService.getCustomerByName(customerName);
    }

}
