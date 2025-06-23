package org.example.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String brand;
    private String ref;
    private Date purchaseDate;
    private double price;
    private int stock;

    @OneToMany(mappedBy = "product")
    private List<ProductPicture> productPictures;

    @OneToMany(mappedBy = "product")
    private List<ProductComment> productComments;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", ref='" + ref + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", price=" + price +
                ", stock=" + stock +
                ", productPictures=" + productPictures +
                ", productComments=" + productComments +
                '}';
    }
}
