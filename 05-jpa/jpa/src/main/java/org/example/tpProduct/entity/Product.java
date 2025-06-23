package org.example.tpProduct.entity;

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

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    protected String name;
    protected double price;
}
