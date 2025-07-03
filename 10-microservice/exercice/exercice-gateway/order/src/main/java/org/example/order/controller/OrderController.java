package org.example.order.controller;

import org.example.order.dto.OrderReceiveDto;
import org.example.order.dto.OrderResponseDto;
import org.example.order.model.Customer;
import org.example.order.model.Order;
import org.example.order.model.Product;
import org.example.order.service.OrderService;
import org.example.order.util.RestClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> getAll() { return ResponseEntity.ok(orderService.get()); }

    @PostMapping
    public ResponseEntity<OrderResponseDto> create(@RequestBody OrderReceiveDto order) { return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(order)); }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDto> getById(@PathVariable Integer id) { return ResponseEntity.ok(orderService.get(id)); }

}
