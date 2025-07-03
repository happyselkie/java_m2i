package org.example.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.order.dto.OrderResponseDto;

import static org.apache.tomcat.util.net.openssl.OpenSSLStatus.getName;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    private Integer id;
    private String description;

    private Integer customerId;
    private Integer productId;
}
