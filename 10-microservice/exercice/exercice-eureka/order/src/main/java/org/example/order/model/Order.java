package org.example.order.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.order.dto.OrderResponseDto;

import static org.apache.tomcat.util.net.openssl.OpenSSLStatus.getName;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String description;

    private Integer customerId;
    private Integer productId;
}
