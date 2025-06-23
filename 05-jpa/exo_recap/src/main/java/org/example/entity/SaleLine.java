package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class SaleLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLine;

    private int productQuantity;

    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="idSale")
    private Sale sale;

    @Override
    public String toString() {
        return product.getName() + " (ref: "+product.getRef()+") x " + productQuantity + " = " + totalPrice +"€";
    }
}
