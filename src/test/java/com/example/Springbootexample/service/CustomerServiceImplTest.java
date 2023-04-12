package com.example.Springbootexample.service;

import com.example.Springbootexample.entity.Customer;
import com.example.Springbootexample.repoitory.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        Customer customerRepo = new Customer(4l, "samuel", "samuelpeter@gmail.com", 28);
        Mockito.when(customerRepository.findByNameIgnoreCase("samuel"))
                .thenReturn(customerRepo);
    }


    @Test
    @DisplayName("Get valid customer based on Name")
    public void testCustomerName(){
//        given
    String customer = "samuel";

//        when
        Customer found = customerService.getCustomerByName(customer);
        System.out.println(found);

//        then
        assertEquals(customer, found.getName());

    }
}