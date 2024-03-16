package com.mvc.banking.repository;

import com.mvc.banking.controller.Customer;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository
public class TextFileCustomerRepository implements CustomerRepository {

    private String filePath;

    public TextFileCustomerRepository() {
        // Construct the file path
        String directoryPath = "src/main/java/com/mvc/banking/repository";
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
                // Extract data using regular expressions
                Matcher matcher = Pattern.compile("name=(.*?),\\s*email=(.*?),\\s*password=(.*?),\\s*address=(.*?),\\s*city=(.*?),\\s*state=(.*?),\\s*zipcode=(.*?)\\)").matcher(line);
                if (matcher.find()) {
                    String name = matcher.group(1);
                    String email = matcher.group(2);
                    String password = matcher.group(3);
                    String address = matcher.group(4);
                    String city = matcher.group(5);
                    String state = matcher.group(6);
                    String zipcode = matcher.group(7);

                    // Create a new Customer object and add it to the list
                    Customer customer = new Customer(name, email, password, address, city, state, zipcode);
                    customers.add(customer);
                }
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
