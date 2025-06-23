package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int idProduct;

    protected String ref;
    protected String name;
    protected String description;
    protected double price;
    protected int stock;
    protected Date restockDate;
    protected boolean active;

    @OneToMany(mappedBy = "product")
    private List<SaleLine> saleLines;
}
