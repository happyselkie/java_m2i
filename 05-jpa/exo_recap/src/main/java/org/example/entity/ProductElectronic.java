package org.example.entity;

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
public class ProductElectronic extends Product{

    private int autonomy;

    @Override
    public String toString() {
        return "---- Électronique "+name+"(id:"+idProduct+") ----\n"+
                "Référence : " + ref + "\n"+
                "Autonomie : " + autonomy + "\n"+
                "Description :" + description + "\n"+
                "Prix :" + price + "\n"+
                "Stock : " + stock + "\n"+
                "Date de restock : " + restockDate + "\n";
    }

}
