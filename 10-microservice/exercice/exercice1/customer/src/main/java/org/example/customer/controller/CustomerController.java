package org.example.customer.controller;

import org.example.customer.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable int id) {
        return new Customer(id, "Toto");
    }

}


