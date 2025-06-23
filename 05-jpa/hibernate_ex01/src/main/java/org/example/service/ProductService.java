package org.example.service;

import org.example.entity.Product;
import org.example.entity.ProductComment;
import org.example.entity.ProductPicture;
import org.example.repository.ProductCommentDAO;
import org.example.repository.ProductDAO;
import org.example.repository.ProductPictureDAO;

import javax.persistence.EntityNotFoundException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class ProductService {

    private ProductDAO productDAO;
    private ProductPictureDAO productPictureDAO;
    private ProductCommentDAO productCommentDAO;

    public ProductService() {
        productDAO = new ProductDAO();
        productPictureDAO = new ProductPictureDAO();
        productCommentDAO = new ProductCommentDAO();
    }

    public Product getById(int id) throws EntityNotFoundException { return productDAO.get(id); }

    public List<Product> getAll() {return productDAO.get();}

    public List<Product> getByBrand(String brand) {return productDAO.getByBrand(brand);}

    public List<Product> getByDates(LocalDate from, LocalDate to) { return productDAO.getFromToDates(from, to); }

    public Double getAvgPrice(){ return productDAO.getAvgPrice();}

    public Product create(String name, String brand, String ref, double price, int stock, Date purchaseDate) {
        Product product = Product.builder().name(name).brand(brand).ref(ref).price(price).stock(stock).purchaseDate(purchaseDate).build();
        return productDAO.save(product);
    }

    public Product update(Product product) {
        try{
            productDAO.get(product.getId());
            return productDAO.save(product);
        } catch (EntityNotFoundException e){
            System.out.println("Ce produit n'existe pas");
            return null;
        }
    }

    public void delete(int id) {
        Product product = productDAO.get(id);
        List<ProductPicture> productPictures = product.getProductPictures();
        List<ProductComment> productComments = product.getProductComments();
        for (ProductPicture productPicture : productPictures) {
            productPictureDAO.delete(productPicture.getId());
        }
        for (ProductComment productComment : productComments) {
            productCommentDAO.delete(productComment.getId());
        }
        productDAO.delete(id);
    }

    public List<ProductPicture> getProductPictures(int id) { return productDAO.getProductPictures(id); }

    public List<ProductComment> getProductComments(int id) { return productDAO.getProductComments(id); }

    public ProductPicture addProductPicture(Product product, String url){
        try{
            ProductPicture productPicture = ProductPicture.builder().path(url).product(product).build();
           productPictureDAO.save(productPicture);
            return productPicture;
        } catch (EntityNotFoundException e){
            System.out.println("Ce produit n'existe pas");
            return null;
        }
    }

    public ProductComment addProductComment(Product product, String content, Date publishedDate, float rating){
        try{
            ProductComment productComment = ProductComment.builder().content(content).publishedDate(publishedDate).rating(rating).product(product).build();
            productCommentDAO.save(productComment);
            return productComment;
        } catch (EntityNotFoundException e){
            System.out.println("Ce produit n'existe pas");
            return null;
        }
    }

    public void deleteProductPicture(int idPicture){
        try{
            productPictureDAO.delete(idPicture);
        } catch (EntityNotFoundException e){
            System.out.println("Ce produit n'existe pas");
        }
    }

    public void deleteProductComment(int idComment){
        try{
           ProductComment productComment = productCommentDAO.get(idComment);
            productCommentDAO.delete(idComment);
        } catch (EntityNotFoundException e){
            System.out.println("Ce produit n'existe pas");
        }
    }

    public List<Product> getProductByRating (int idProduct, float rating){
        return productDAO.getProductByRating(idProduct, rating);
    }

    public ProductPicture getPicture(int idPicture){
        return productPictureDAO.get(idPicture);
    }

    public ProductComment getComment(int idComment){
        return productCommentDAO.get(idComment);
    }

}
