package org.example.tpProduct.service;

import org.example.tpProduct.dao.ProductDAO;
import org.example.tpProduct.entity.Product;
import org.example.tpProduct.entity.Product_Electronic;
import org.example.tpProduct.entity.Product_Food;
import org.example.tpProduct.entity.Product_Housing;
import org.example.tp_parc.entity.Computer;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class ProductService {

    private ProductDAO productDAO;

    public ProductService() { productDAO = new ProductDAO(); }

        public Product getProductById(int id) throws EntityNotFoundException { return productDAO.getById(id, Product.class); }

     public List<Product> getAllProducts() {return productDAO.getAll();}

     public List<Product_Food> getFoods() {return productDAO.getFoods();}

     public List<Product_Electronic> getEletronics() {return productDAO.getElectronics();}

     public List<Product_Housing> getHousings() {return productDAO.getHousings();}

    public Product createFoods(String name, double price, Date expirationDate) {
        Product_Food food = Product_Food.builder().name(name).price(price).expirationDate(expirationDate).build();
        return productDAO.save(food);
    }

    public Product createElectronic(String name, double price, int autonomy) {
        Product_Electronic electronic = Product_Electronic.builder().name(name).price(price).autonomy(autonomy).build();
        return productDAO.save(electronic);
    }

    public Product createHousing(String name, double price, double height, double width) {
        Product_Housing housing = Product_Housing.builder().name(name).height(height).width(width).build();
        return productDAO.save(housing);
    }

    public void updateProduct (Product product) {
        try{
            productDAO.getById(product.getId(), Product.class);
            productDAO.update(product);
        } catch (EntityNotFoundException e){
            System.out.println("Ce produit n'existe pas");
        }
    }

    public void deleteProduct (int id) {productDAO.delete(id, Product.class);}
}
