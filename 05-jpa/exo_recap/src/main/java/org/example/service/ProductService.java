package org.example.service;

import org.example.entity.Product;
import org.example.entity.ProductClothe;
import org.example.entity.ProductElectronic;
import org.example.entity.ProductFood;
import org.example.repository.ProductDAO;
import org.example.enums.ClotheCategory;
import org.example.enums.ClotheSize;

import javax.persistence.EntityNotFoundException;
import java.sql.Date;
import java.util.List;


public class ProductService {
    private ProductDAO productDAO;

    public ProductService() {
    productDAO = new ProductDAO();
    }

    public Product getById(int id) throws EntityNotFoundException { return productDAO.get(id); }

    public Product getByRef(String ref) throws EntityNotFoundException { return productDAO.getByRef(ref); }

    public List<Product> getAll() {return productDAO.get();}

    public List<ProductFood> getFoods() {return productDAO.getFoods();}

    public List<ProductElectronic> getElectronics() {return productDAO.getElectronics();}

    public List<ProductClothe> getClothes() {return productDAO.getClothes();}

    public List<Product> getUnderStockAmount(int amount) {return productDAO.getUnderStockAmount(amount);}

    public ProductFood createFood(String ref, String name, String description, double price, int stock, Date restockDate, Date expirationDate) {
        ProductFood food = ProductFood.builder().ref(ref).name(name).description(description).price(price).stock(stock).restockDate(restockDate).expirationDate(expirationDate).active(true).build();
        productDAO.save(food);
        return food;
    }

    public ProductElectronic createElectronic(String ref, String name, String description, double price, int stock, Date restockDate, int autonomy) {
        ProductElectronic electronic = ProductElectronic.builder().ref(ref).name(name).description(description).price(price).stock(stock).restockDate(restockDate).autonomy(autonomy).active(true).build();
        productDAO.save(electronic);
        return electronic;
    }

    public ProductClothe createClothe(String ref, String name, String description, double price, int stock, Date restockDate, ClotheCategory clotheCategory, ClotheSize clotheSize) {
        ProductClothe clothe = ProductClothe.builder().ref(ref).name(name).description(description).price(price).stock(stock).restockDate(restockDate).clotheCategory(clotheCategory).clotheSize(clotheSize).active(true).build();
        productDAO.save(clothe);
        return clothe;
    }

    public Product update(Product product) {
        try{
            productDAO.get(product.getIdProduct());
            return productDAO.save(product);
        } catch (EntityNotFoundException e){
            System.out.println("Ce produit n'existe pas");
            return null;
        }
    }

    public void deleteProduct(int id) { productDAO.delete(id); }

    public int getAvgStockFoods() { return productDAO.getAvgStockFoods(); }

    public int getAvgStockElectronics() { return productDAO.getAvgStockElectronics(); }

    public int getAvgStockClothes() { return productDAO.getAvgStockClothes(); }

    public void desactivateProduct(int id) { productDAO.desactivateProduct(id); }
}
