package org.example.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.customer.model.Customer;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerReceiveDto {

    private String name;
    private double price;

    public Customer dtoToEntity(){
        return Customer.builder()
                .name(getName())
                .build();
    }
}
