package org.example.order.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.order.model.Customer;
import org.example.order.model.Product;
import org.example.order.util.RestClient;
import org.springframework.web.client.RestTemplate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderResponseDto {
    private String description;

    private CustomerResponseDto customer;
    private ProductResponseDto product;
}
