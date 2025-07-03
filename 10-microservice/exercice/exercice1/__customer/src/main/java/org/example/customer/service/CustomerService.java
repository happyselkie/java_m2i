package org.example.customer.service;

import org.example.customer.dto.CustomerReceiveDto;
import org.example.customer.dto.CustomerResponseDto;
import org.example.customer.exception.NotFoundException;
import org.example.customer.model.Customer;
import org.example.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponseDto create(CustomerReceiveDto customerReceiveDto){
        return customerRepository.save(customerReceiveDto.dtoToEntity()).entityToDto();
    }

    public CustomerResponseDto get(Integer id){ return customerRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto(); }

    public List<CustomerResponseDto> get(){
        return customerRepository.findAll().stream().map(Customer::entityToDto).toList();
    }

    public CustomerResponseDto update(Integer id, CustomerReceiveDto customerReceiveDto){
        Customer customerToUpdate = customerRepository.findById(id).orElseThrow(NotFoundException::new);
        Customer customerGet = customerReceiveDto.dtoToEntity();
        customerToUpdate.setName(customerGet.getName());
        return customerRepository.save(customerToUpdate).entityToDto();
    }

    public void delete(Integer id){ customerRepository.deleteById(id); }
}
