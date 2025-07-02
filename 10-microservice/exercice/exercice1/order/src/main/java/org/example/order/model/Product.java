package org.example.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.order.dto.ProductResponseDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private int id;
    private String name;;
    private double price;

    public ProductResponseDto entityToDto() {
        return ProductResponseDto.builder()
                .name(getName())
                .price(getPrice())
                .build();
    }
}
