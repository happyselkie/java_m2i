package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String path;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="idProduct")
    private Product product;

    @Override
    public String toString() {
        return "ProductPicture{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", product name=" + product.getName() +
                '}';
    }
}
