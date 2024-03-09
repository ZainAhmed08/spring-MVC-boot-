package com.mvc.banking.controller;

import com.mvc.banking.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
class HelloController {

    @Autowired
    CustomerService customerService;

    Logger log = LoggerFactory.getLogger(HelloController.class);

//    @GetMapping("")
//    public String homePage() {
//        return "testing";
//    }

    @GetMapping("/")
    public ModelAndView homePage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("title","The holy Quran");
        return mv;
    }

    @GetMapping("/allCustomers")
    public ModelAndView getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        log.info("the customer list is : "+customers);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("customersTableUI");
        mv.addObject("customers",customers);
        return mv;
    }


    @GetMapping("register")
    public ModelAndView register(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("address") String address,
            @RequestParam("city") String city,
            @RequestParam("state") String state,
            @RequestParam("zipcode") String zipcode) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("registrationComplete");

        Customer customer = new Customer(name,email,password,address,city,state,zipcode);

        customerService.addCustomer(customer);

        log.info(" and the customer is : "+customer);
        mv.addObject("customer",customer);
        System.out.println("ModelAndView contents: " + mv.getModel());

        return mv;
    }
}