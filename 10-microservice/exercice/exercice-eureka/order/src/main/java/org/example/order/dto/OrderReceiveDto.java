package org.example.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.order.model.Customer;
import org.example.order.model.Order;
import org.example.order.model.Product;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderReceiveDto {

    private String name;
    private String description;
    private Integer customerId;
    private Integer productId;

    public Order dtoToEntity(){
        return Order.builder()
                .description(getDescription())
                .customerId(getCustomerId())
                .productId(getProductId())
                .build();
    }
}
