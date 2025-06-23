package org.example.tpProduct.dao;

import org.example.tpProduct.entity.Product;
import org.example.tpProduct.entity.Product_Electronic;
import org.example.tpProduct.entity.Product_Food;
import org.example.tpProduct.entity.Product_Housing;

import java.util.List;

public class ProductDAO extends BaseDAO<Product> {

    public List<Product> getAll(){
        return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    public List<Product_Food> getFoods(){
        return em.createQuery("SELECT p FROM Product_Food p", Product_Food.class).getResultList();
    }

    public List<Product_Electronic> getElectronics(){
        return em.createQuery("SELECT p FROM Product_Electronic p", Product_Electronic.class).getResultList();
    }

    public List<Product_Housing> getHousings(){
        return em.createQuery("SELECT p FROM Product_Housing p", Product_Housing.class).getResultList();
    }
}
