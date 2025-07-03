package org.example.customer.controller;

import org.example.customer.dto.CustomerReceiveDto;
import org.example.customer.dto.CustomerResponseDto;
import org.example.customer.model.Customer;
import org.example.customer.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> getAll() { return ResponseEntity.ok(customerService.get()); }

    @PostMapping
    public ResponseEntity<CustomerResponseDto> create(@RequestBody CustomerReceiveDto customer) { return ResponseEntity.status(HttpStatus.CREATED).body(customerService.create(customer)); }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> getById(@PathVariable Integer id) { return ResponseEntity.ok(customerService.get(id)); }
}


