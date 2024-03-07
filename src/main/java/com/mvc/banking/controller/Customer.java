package com.mvc.banking.controller;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

    private String name;
    private String email;
    private String password;
    private String address;
    private String city;
    private String state;
    private String zipcode;

}
