package org.example.order.service;

import org.example.order.dto.OrderReceiveDto;
import org.example.order.dto.OrderResponseDto;
import org.example.order.exception.NotFoundException;
import org.example.order.model.Customer;
import org.example.order.model.Order;
import org.example.order.model.Product;
import org.example.order.repository.OrderRepository;
import org.example.order.util.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private final RestTemplate restTemplate;
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    public OrderResponseDto orderToOrderResponseDto(Order order) {
        Customer customer = getCustomer(order.getCustomerId());
        Product product = getProduct(order.getProductId());
        return new OrderResponseDto(order.getDescription(), customer, product);
    }

    public Customer getCustomer(Integer id){
        RestClient<Customer> customerRestClient = new RestClient<>("http://CUSTOMER/customer/"+id, restTemplate);
        Customer customer = customerRestClient.get(Customer.class);
        return customer;
    }

    public Product getProduct(Integer id){
        RestClient<Product> productRestClient = new RestClient<>("http://PRODUCT/product/"+id, restTemplate);
        Product product = productRestClient.get(Product.class);
        return product;
    }

    public OrderResponseDto create(OrderReceiveDto orderReceiveDto){
        return orderToOrderResponseDto(orderRepository.save(orderReceiveDto.dtoToEntity()));
    }

    public OrderResponseDto get(Integer id){
        return orderToOrderResponseDto(orderRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    public List<OrderResponseDto> get(){
        List<OrderResponseDto> responses = new ArrayList<>();
        for(Order order : orderRepository.findAll()){
            OrderResponseDto orderResponseDto = orderToOrderResponseDto(order);
            responses.add(orderResponseDto);
        }
        return responses;
    }

    public OrderResponseDto update(Integer id, OrderReceiveDto orderReceiveDto){
        Order orderToUpdate = orderRepository.findById(id).orElseThrow(NotFoundException::new);
        Order orderGet = orderReceiveDto.dtoToEntity();
        orderToUpdate.setDescription(orderGet.getDescription());
        orderToUpdate.setCustomerId(orderGet.getCustomerId());
        orderToUpdate.setProductId(orderGet.getProductId());
        return orderToOrderResponseDto(orderRepository.save(orderToUpdate));
    }

    public void delete(Integer id){ orderRepository.deleteById(id); }
}
