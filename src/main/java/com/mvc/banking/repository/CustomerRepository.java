package com.mvc.banking.repository;

import com.mvc.banking.controller.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository {
    List<Customer> findAll();
    Customer findById(String customerId);
    void save(Customer customer);
    void delete(String customerId);
}
