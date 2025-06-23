package org.example.exercice_tp;

import java.util.Map;

public class Bulk extends Products{

    private Products product;
    private int quantity;
    private double discountPercent;

    public Bulk(String ref, Products product, int quantity, double discountPercent) {
        super(ref);
        this.product = product;
        this.quantity = quantity;
        this.discountPercent = discountPercent;
    }

    public Map<String, Products> getAllProducts() {
        return allProducts;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }


    public double getPrice(){
        double productPrice = product.getPrice();
        double totalProduct = productPrice * quantity;

        totalProduct = totalProduct - (totalProduct * discountPercent / 100.0);

        return totalProduct;
    }

    @Override
    public String getName() {
        return "Bulk of "+this.quantity + " " +product.getName();
    }

    @Override
    public String getRef() {
        return this.ref;
    }

    @Override
    public Products getProduct() {
        return this.product;
    }

    @Override
    public String toString() {
        return "Bulk{" +
                "ref='" + ref + '\'' +
                ", product=" + product +
                ", quantity=" + quantity +
                ", discountPercent=" + discountPercent +
                '}';
    }
}
