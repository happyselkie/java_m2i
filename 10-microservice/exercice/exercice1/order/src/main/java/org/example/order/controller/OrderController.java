package org.example.order.controller;

import org.example.order.model.Customer;
import org.example.order.model.Order;
import org.example.order.model.Product;
import org.example.order.util.RestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int id) {
        Order order = new Order();
        order.setId(id);
        order.setDescription("Blabla");

        RestClient<Customer> customerRestClient = new RestClient<>("http://localhost:8080/customer/5");
        Customer customer = customerRestClient.get(Customer.class);

        RestClient<Product> productRestClient = new RestClient<>("http://localhost:8081/product/12");
        Product product = productRestClient.get(Product.class);

        order.setCustomer(customer);
        order.setProduct(product);
        return order;
    }




}
