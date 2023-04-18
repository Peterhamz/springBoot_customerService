//package com.example.Springbootexample.repoitory;
//
//import com.example.Springbootexample.entity.Customer;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//
//@DataJpaTest
//class CustomerRepositoryTest {
//    @Autowired
//    private CustomerRepository customerRepository;
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @BeforeEach
//    void setUp() {
////        Given
//        Customer customerRepo = new Customer(7l, "samuel", "samuelpeter@gmail.com", 28);
//
//        entityManager.persist(customerRepo);
//    }
//    @Test
//    public void findByIds(){
////        When
//        Customer customer = customerRepository.findById(7l).get();
//
////        Then
//        assertEquals(customer.getName(), "samuel");
//
//    }
//}