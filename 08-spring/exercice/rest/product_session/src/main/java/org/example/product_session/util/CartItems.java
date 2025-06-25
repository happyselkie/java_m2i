package org.example.product_session.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.product_session.dto.ProductResponseDto;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartItems {

    private ProductResponseDto product;
    private int quantity;

}
