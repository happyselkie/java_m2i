package org.example.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.order.dto.CustomerResponseDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    private int id;
    private String name;

    public CustomerResponseDto entityToDto() {
        return CustomerResponseDto.builder()
                .name(getName())
                .build();
    }
}
