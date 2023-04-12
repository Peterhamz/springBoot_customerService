package com.example.Springbootexample.controller;

import com.example.Springbootexample.dto.NewCustomerRequest;
import com.example.Springbootexample.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    private NewCustomerRequest newCustomerRequest;

    @BeforeEach
    void setUp() {
        newCustomerRequest = new NewCustomerRequest("phjames", "phjames@gmail.com", 22);
    }

    @Test
    void getCustomerById() {
    }

    @Test
    void addCustomer() throws Exception {
       NewCustomerRequest  inputCustomer = new NewCustomerRequest("hamza", "hamza@gmail.com", 35);

        Mockito.when(customerService.addCustomer(inputCustomer)).thenReturn(String.valueOf(newCustomerRequest));

        mockMvc.perform(MockMvcRequestBuilders.post("/addCustomer")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"name\":\"phjames\",\n" +
                        "\t\"email\":\"phjames@gmail.com\",\n" +
                        "\t\"age\":22\n" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}