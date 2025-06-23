package org.example.exercice_tp;

import java.util.HashMap;
import java.util.Map;

abstract class Products {
    protected String ref;

    public static Map<String, Products> allProducts = new HashMap<>();

    public Products(String ref) {
        this.ref = ref;
        allProducts.put(ref, this);
    }

    public abstract  Map<String, Products> getAllProducts();

    public abstract String getRef();

    public abstract Products getProduct();

    public abstract double getPrice();

    public abstract String getName();

    @Override
    public String toString() {
        return "Products{" +
                "ref='" + ref + '\'' +
                '}';
    }
}
