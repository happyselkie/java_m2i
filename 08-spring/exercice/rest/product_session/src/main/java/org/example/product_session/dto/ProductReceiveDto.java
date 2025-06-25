package org.example.product_session.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.product_session.entity.Product;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductReceiveDto {

    @Size(min = 3, max = 25, message = "La date doit être comprise entre 3 et 25")
    private String name;

    @Positive(message = "Le prix doit être positif")
    private Double price;

    public Product dtoToEntity(){
        return Product.builder()
                .name(getName())
                .price(getPrice())
                .build();

    }
}
