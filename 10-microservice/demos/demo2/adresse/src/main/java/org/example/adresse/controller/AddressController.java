package org.example.adresse.controller;

import org.example.adresse.model.Address;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("address")
public class AddressController {

    @GetMapping("/{id}")
    public Address getAddress(@PathVariable int id) {
        return new Address(id, "rue des pias", "Tourcoing", 59200, "France");
    }
}
