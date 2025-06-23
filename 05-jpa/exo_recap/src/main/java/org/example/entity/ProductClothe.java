package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.enums.ClotheCategory;
import org.example.enums.ClotheSize;

import javax.persistence.Entity;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ProductClothe extends Product{

    private ClotheCategory clotheCategory;
    private ClotheSize clotheSize;


    @Override
    public String toString() {
        return "---- Vêtement "+name+"(id:"+idProduct+") ----\n"+
                "Référence : " + ref + "\n"+
                "Catégorie : " + clotheCategory + "\n"+
                "Taille : " + clotheSize + "\n"+
                "Description :" + description + "\n"+
                "Prix :" + price + "\n"+
                "Stock : " + stock + "\n"+
                "Date de restock : " + restockDate + "\n";
    }
}
