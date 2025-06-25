package org.example.product_session.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.product_session.dto.ProductResponseDto;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CartItems {

    private Long productId;
    private int quantity;

}
