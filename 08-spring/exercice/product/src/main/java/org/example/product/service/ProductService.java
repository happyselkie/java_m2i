package org.example.product.service;

import org.example.product.model.Product;
import org.example.product.util.Category;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Primary
public class ProductService implements ModelService<Product> {

    private final Map<UUID, Product> products;

    public ProductService() {

        this.products = new HashMap<>();

        Product product1 = Product.builder()
                .id(UUID.randomUUID())
                .name("PS5 Slim")
                .category(Category.Console)
                .price(549.00)
                .build();
        this.products.put(product1.getId(), product1);

        Product product2 = Product.builder()
                .id(UUID.randomUUID())
                .name("PS5")
                .category(Category.Console)
                .price(658.69)
                .build();
        this.products.put(product2.getId(), product2);

        Product product3 = Product.builder()
                .id(UUID.randomUUID())
                .name("T-shirt")
                .category(Category.Clothing)
                .price(14.5)
                .build();
        this.products.put(product3.getId(), product3);

        Product product4 = Product.builder()
                .id(UUID.randomUUID())
                .name("Switch")
                .category(Category.Console)
                .price(350.00)
                .build();
        this.products.put(product4.getId(), product4);

        Product product5 = Product.builder()
                .id(UUID.randomUUID())
                .name("Xbox")
                .category(Category.Console)
                .price(549.00)
                .build();
        this.products.put(product5.getId(), product5);

        Product product6 = Product.builder()
                .id(UUID.randomUUID())
                .name("Chaussettes")
                .category(Category.Clothing)
                .price(3.00)
                .build();
        this.products.put(product6.getId(), product6);
    }

    @Override
    public List<Product> findAll() { return this.products.values().stream().toList(); }

    @Override
    public Product findById(UUID id) { return this.products.get(id); }

    public List<Product> findByCategory(List<Product> productList, Category category){
        return productList.stream().filter(c -> c.getCategory().equals(category)).toList();
    }

    public List<Product> findByUnderAmount(List<Product> productList, double amount){
        return productList.stream().filter(c -> c.getPrice() <= amount).toList();
    }

    @Override
    public Product save(Product model) {
        products.put(model.getId(), model);
        return model;
    }

    @Override
    public Product delete(Product model) {
        products.remove(model);
        return model;
    }

}

