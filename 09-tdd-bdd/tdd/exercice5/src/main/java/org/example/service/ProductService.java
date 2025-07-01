package org.example.service;

import org.example.entity.Product;
import org.example.exception.InvalidArgumentException;

public class ProductService {

    public void update(Product product) {
        product.setSellIn(product.getSellIn()-1);
        int decrement = 1;
        if (product.getSellIn() <= 0){
            decrement = 2;
        }

        if (product.getType().equals("laitier")) {
            if (product.getName().equals("Brie vieilli")) {
                if (product.getQuality() + 1 > 50) throw new InvalidArgumentException("La qualité ne peut pas être supérieure à 50");
                else product.setQuality(product.getQuality() + 1);
            }
            else {
                if (product.getQuality() - (decrement * 2) < 0) throw new InvalidArgumentException("La qualité ne peut pas être inférieure à 0");
                product.setQuality(product.getQuality() - (decrement * 2));
            }
        } else {
            if (product.getQuality() - decrement < 0) throw new InvalidArgumentException("La qualité ne peut pas être inférieure à 0");
            product.setQuality(product.getQuality() - decrement);
        }
    }

}

