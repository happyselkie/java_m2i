package org.example.tpProduct.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Product_Electronic extends Product{

    private int autonomy;

}
