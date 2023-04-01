package com.example.Springbootexample;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public String addCustomer(NewCustomerRequest request) {
        Customer customer = new Customer();
        customer.setAge(request.getAge());
        customer.setEmail(request.getEmail());
        customer.setName(request.getName());
        customerRepository.save(customer);
        return "Successfully added";
    }

    @Override
    public void deleteCustomer(Long customerId) {
        boolean exist = customerRepository.existsById(customerId);
        if (!exist){
            throw new IllegalStateException("Customer with " + customerId + " do not exist");
        }
        customerRepository.deleteById(customerId);
    }

    @Override
    public void editCustomer(Long customerId, NewCustomerRequest request) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(()-> new IllegalStateException("Customer not found"));

        customer.setName(request.getName());
        customer.setAge(request.getAge());
        customer.setEmail(request.getEmail());

         customerRepository.save(customer);

    }
}
