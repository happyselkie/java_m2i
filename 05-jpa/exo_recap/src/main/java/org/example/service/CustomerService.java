package org.example.service;

import org.example.entity.Customer;
import org.example.repository.CustomerDAO;

import javax.persistence.EntityNotFoundException;

public class CustomerService {

    CustomerDAO customerDAO;

    public CustomerService() {customerDAO = new CustomerDAO();}

    public Customer getById(int id) throws EntityNotFoundException { return customerDAO.get(id); }

    public Customer create(String name, String address, String email) {
        Customer customer = Customer.builder().name(name).address(address).email(email).build();
        return customerDAO.save(customer);
    }

    public Customer update(Customer customer) {
        try{
            customerDAO.get(customer.getIdCustomer());
            return customerDAO.save(customer);
        } catch (EntityNotFoundException e){
            System.out.println("Ce client n'existe pas");
            return null;
        }
    }

    public void desactiveCustomer(int id) { customerDAO.desactivateCustomer(id); }
}
