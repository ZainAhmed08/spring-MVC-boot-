package com.mvc.banking.service;

import com.mvc.banking.controller.Customer;
import com.mvc.banking.repository.CustomerRepository;
import com.mvc.banking.repository.TextFileCustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService() {
        // Initialize the repository with the file path
        this.customerRepository = new TextFileCustomerRepository();
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    // Other service methods...
}
