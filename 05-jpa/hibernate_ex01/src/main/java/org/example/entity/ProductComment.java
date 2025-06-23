package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;
    private Date publishedDate;
    private float rating;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="idProduct")
    private Product product;

    @Override
    public String toString() {
        return "ProductComment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", publishedDate=" + publishedDate +
                ", rating=" + rating +
                ", product name =" + product.getName() +
                '}';
    }
}
