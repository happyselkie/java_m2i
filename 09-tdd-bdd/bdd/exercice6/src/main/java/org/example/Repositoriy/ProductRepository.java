package org.example.Repositoriy;

import org.example.Model.Product;

import java.util.List;

public class ProductRepository implements BaseRepository<Product> {
    @Override
    public Product add(Product element) {
        return null;
    }

    @Override
    public boolean delete(Product element) {
        return false;
    }

    @Override
    public Product update(Product element) {
        return null;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    public List<Product> findByName(String name) {
        // search wit LIKE
        return null;
    }

    public List<Product> findByPrice(float price) {
        // search wit price < ?
        return null;
    }
    public List<Product> findByCategory(String category) {
        // search wit category = ?
        return null;
    }


    @Override
    public List<Product> findAll() {
        return null;
    }
}
