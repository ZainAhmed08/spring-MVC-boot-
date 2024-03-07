package com.mvc.banking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
class HelloController {

    Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("")
    public String homePage() {
        return "index";
    }


//    @RequestMapping("register")
//    public void logOutput() {
//        log.info("inside this method lol");
//    }

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
        mv.setViewName("registration-success");

        Customer customer = new Customer(name,email,password,address,city,state,zipcode);
        log.info(" and the customer is : "+customer);
        mv.addObject("customer",customer);
        return mv;
    }
}