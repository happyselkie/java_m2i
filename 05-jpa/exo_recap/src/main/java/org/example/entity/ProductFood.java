package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.sql.Date;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ProductFood extends Product{

    Date expirationDate;

    @Override
    public String toString() {
        return "---- Aliment "+name+"(id:"+idProduct+") ----\n"+
                "Référence : " + ref + "\n"+
                "Date d'expiration : " + expirationDate + "\n"+
                "Description :" + description + "\n"+
                "Prix :" + price + "\n"+
                "Stock : " + stock + "\n"+
                "Date de restock : " + restockDate + "\n";
    }

}
