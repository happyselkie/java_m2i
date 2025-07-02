package org.example.order.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.order.model.Customer;
import org.example.order.model.Product;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderResponseDto {
    private String name;
    private String description;
    private CustomerResponseDto customer;
    private ProductResponseDto product;
}
