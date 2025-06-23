package org.example.repository;

import org.example.entity.Product;
import org.example.entity.ProductComment;
import org.example.entity.ProductPicture;
import org.example.util.SessionFactorySingleton;

import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends BaseDAO<Product> {

    public ProductDAO() {
        super(SessionFactorySingleton.getSessionFactory(), Product.class);
    }

    @Override
    public List<Product> get() {
        try{
            session = sessionFactory.openSession();
            List<Product> products = session.createQuery("select p from Product p", Product.class).getResultList();

            for (Product product : products) {
                product.setProductPictures(session.createQuery("select p from ProductPicture p where p.product = product", ProductPicture.class).getResultList());
                product.setProductComments(session.createQuery("select p from ProductComment p where p.product = product", ProductComment.class).getResultList());
            }

            return products;
        }catch (Exception ex){
            return new ArrayList<>();
        }finally {
            session.close();
        }
    }

    @Override
    public Product get(int id) {
        try{
            session = sessionFactory.openSession();
            Product product = session.get(Product.class,id);

            product.setProductPictures(session.createQuery("select p from ProductPicture p where p.product = product", ProductPicture.class).getResultList());
            product.setProductComments(session.createQuery("select p from ProductComment p where p.product = product", ProductComment.class).getResultList());


            return product;
        }catch (Exception ex){
            return null;
        }finally {
            session.close();
        }
    }

    public List<Product> getByPriceUnderAmount(int amount){
        try{
            session = sessionFactory.openSession();
            TypedQuery<Product> query = session.createQuery("select p from Product p where p.price <= :amount ", Product.class);
            query.setParameter("amount", amount);
            return query.getResultList();
        } catch (Exception ex){
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }


    public List<Product> getFromToDates(LocalDate from, LocalDate to){

        try{
            session = sessionFactory.openSession();
            TypedQuery<Product> query = session.createQuery("select p from Product p where p.purchaseDate between :from and :to", Product.class);
            query.setParameter("from", from);
            query.setParameter("to", to);
            return query.getResultList();
        } catch (Exception ex){
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }

    public List<Product> getRefUnderStock(int stock){
        try{
            session = sessionFactory.openSession();
            TypedQuery<Product> query = session.createQuery("select p.ref from Product p where p.stock < :stock", Product.class);
            query.setParameter("stock", stock);
            return query.getResultList();
        } catch (Exception ex){
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }

    public long getStockByBrand(String brand){
        try {
            session = sessionFactory.openSession();
            TypedQuery<Long> query = session.createQuery("select sum(p.stock) from Product p where p.brand = :brand", Long.class);
            query.setParameter("brand", brand);
            return query.getSingleResult();
        } catch (Exception ex){
            return 0;
        } finally {
            session.close();
        }
    }

    public double getAvgPrice(){
        try{
            session = sessionFactory.openSession();
            TypedQuery<Double> query = session.createQuery("select avg(p.price) from Product p", Double.class);
            return query.getSingleResult();
        } catch (Exception ex){
            return 0;
        } finally {
            session.close();
        }
    }

    public List<Product> getByBrand(String brand){
        try{
            session = sessionFactory.openSession();
            TypedQuery<Product> query = session.createQuery("select p from Product p where p.brand = :brand", Product.class);
            query.setParameter("brand", brand);
            return query.getResultList();
        } catch (Exception ex){
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }

    public void deleteByBrand(String brand){
        try{
            session = sessionFactory.openSession();
            TypedQuery<Product> query = session.createQuery("delete from Product p where p.brand = :brand", Product.class);
            query.setParameter("brand", brand);
            query.executeUpdate();
        } catch (Exception ex){
            return;
        }
        finally {
            session.close();
        }
    }

    public List<ProductPicture> getProductPictures(int id){
        try{
            Product product = get(id);
            session = sessionFactory.openSession();
            TypedQuery<ProductPicture> query = session.createQuery("select p from ProductPicture p where p.product = product", ProductPicture.class);
            return query.getResultList();
        } catch (EntityNotFoundException ex){
            System.out.println("Product not found");
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }

    public List<ProductComment> getProductComments(int id){
        try{
            Product product = get(id);
            session = sessionFactory.openSession();
            TypedQuery<ProductComment> query = session.createQuery("select p from ProductComment p where p.product = product", ProductComment.class);
            return query.getResultList();
        } catch (EntityNotFoundException ex){
            System.out.println("Product not found");
            return new ArrayList<>();
        }  finally {
            session.close();
        }
    }

    public List<Product> getProductByRating (int idProduct, float rating){
        try{
            session = sessionFactory.openSession();
            Product product = get(idProduct);
            TypedQuery<Product> query = session.createQuery("select c.product from ProductComment c where c.product = product AND avg(c.rating) >= :rating", Product.class);
            query.setParameter("rating", rating);
           return query.getResultList();
        } catch (Exception ex){
            return new ArrayList<>();
        }
        finally {
            session.close();
        }
    }


}
