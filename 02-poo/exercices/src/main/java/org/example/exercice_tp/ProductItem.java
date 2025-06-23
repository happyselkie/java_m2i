package org.example.exercice_tp;

import java.util.Map;

public class ProductItem extends Products{

    private String name;
    private double price;

    public ProductItem(String ref, String name, double price) {
        super(ref);
        this.name = name;
        this.price = price;
    }

    public Map<String, Products> getAllProducts() {
        return allProducts;
    }

    public Products getProduct(String ref) {
        return allProducts.get(ref);
    }

    public String getRef() {
        return this.ref;
    }

    @Override
    public Products getProduct() {
        return this;
    }

    protected void setRef(String ref) {
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    protected void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductItem{" +
                "ref='" + this.ref + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
