package com.mvc.banking.repository;

import com.mvc.banking.controller.Customer;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TextFileCustomerRepository implements CustomerRepository {

    private String filePath;

    public TextFileCustomerRepository() {
        // Construct the file path
        String directoryPath = "C:\\Users\\zaina\\spring-MVC-boot-\\src\\main\\java\\com\\mvc\\banking\\repository";
        String fileName = "customers.txt";
        this.filePath = directoryPath + File.separator + fileName;

        // Check if the file exists, if not, create it
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Customer customer = new Customer(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
                customers.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer findById(String customerId) {
        // Implement logic to find a customer by ID
        return null;
    }

    @Override
    public void save(Customer customer) {
        // Implement logic to save a customer to the text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(customer.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String customerId) {
        // Implement logic to delete a customer from the text file
    }
}
