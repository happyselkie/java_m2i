package org.example.order.service;

import org.example.order.dto.OrderReceiveDto;
import org.example.order.dto.OrderResponseDto;
import org.example.order.exception.NotFoundException;
import org.example.order.model.Order;
import org.example.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderResponseDto create(OrderReceiveDto orderReceiveDto){
        return orderRepository.save(orderReceiveDto.dtoToEntity()).entityToDto();
    }

    public OrderResponseDto get(Integer id){ return orderRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto(); }

    public List<OrderResponseDto> get(){
        return orderRepository.findAll().stream().map(Order::entityToDto).toList();
    }

    public OrderResponseDto update(Integer id, OrderReceiveDto orderReceiveDto){
        Order orderToUpdate = orderRepository.findById(id).orElseThrow(NotFoundException::new);
        Order orderGet = orderReceiveDto.dtoToEntity();
        orderToUpdate.setDescription(orderGet.getDescription());
        orderToUpdate.setCustomer(orderGet.getCustomer());
        orderToUpdate.setProduct(orderGet.getProduct());
        return orderRepository.save(orderToUpdate).entityToDto();
    }

    public void delete(Integer id){ orderRepository.deleteById(id); }
}
