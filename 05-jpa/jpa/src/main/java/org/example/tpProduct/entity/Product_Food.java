package org.example.tpProduct.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.util.Date;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Product_Food extends Product{

    Date expirationDate;

}
