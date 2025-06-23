package org.example.repository;

import org.example.entity.Product;
import org.example.entity.ProductClothe;
import org.example.entity.ProductElectronic;
import org.example.entity.ProductFood;
import org.example.util.SessionFactorySingleton;

import javax.persistence.TypedQuery;
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
            return products;
        }catch (Exception ex){
            return new ArrayList<>();
        }finally {
            session.close();
        }
    }

    public Product getByRef(String ref) {
        try{
            session = sessionFactory.openSession();
            TypedQuery<Product> query = session.createQuery("select p from Product p where p.ref=:ref", Product.class);
            query.setParameter("ref", ref);
            return query.getSingleResult();
        } catch (Exception ex){
            return null;
        } finally {
            session.close();
        }
    }

    public List<ProductFood> getFoods(){
        try{
            session = sessionFactory.openSession();
            List<ProductFood> products = session.createQuery("select p from ProductFood p", ProductFood.class).getResultList();
            return products;
        }catch (Exception ex){
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }

    public List<ProductElectronic> getElectronics(){
        try{
            session = sessionFactory.openSession();
            List<ProductElectronic> products = session.createQuery("select p from ProductElectronic p", ProductElectronic.class).getResultList();
            return products;
        }catch (Exception ex){
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }

    public List<ProductClothe> getClothes(){
        try{
            session = sessionFactory.openSession();
            List<ProductClothe> products = session.createQuery("select p from ProductClothe p", ProductClothe.class).getResultList();
            return products;
        }catch (Exception ex){
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }

    public List<Product> getUnderStockAmount(int stockAmount){
        try{
            session = sessionFactory.openSession();
            TypedQuery<Product> query = session.createQuery("select p.stock from Product p where p.stock < :stockAmount", Product.class);
            query.setParameter("stockAmount", stockAmount);
            return query.getResultList();
        }catch (Exception ex){
            return new ArrayList<>();
        }finally {
            session.close();
        }
    }

    public int getAvgStockFoods(){
        try{
            session = sessionFactory.openSession();
            TypedQuery<Integer> query = session.createQuery("select avg(p.stock) from ProductFood p", Integer.class);
            return query.getSingleResult();
        } catch (Exception ex){
            return 0;
        } finally {
            session.close();
        }
    }

    public int getAvgStockElectronics(){
        try{
            session = sessionFactory.openSession();
            TypedQuery<Integer> query = session.createQuery("select avg(p.stock) from ProductElectronic p", Integer.class);
            return query.getSingleResult();
        } catch (Exception ex){
            return 0;
        } finally {
            session.close();
        }
    }

    public int getAvgStockClothes(){
        try{
            session = sessionFactory.openSession();
            TypedQuery<Integer> query = session.createQuery("select avg(p.stock) from ProductClothe p", Integer.class);
            return query.getSingleResult();
        } catch (Exception ex){
            return 0;
        } finally {
            session.close();
        }
    }

    public void desactivateProduct(int id){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            TypedQuery<Product> query = session.createQuery("update Product p set p.active = false where p.idProduct = :id", Product.class);
            query.setParameter("id", id);
            session.update(query);
            session.getTransaction().commit();
        } catch (Exception ex){
            session.getTransaction().rollback();
            System.out.println("Impossible de désactiver le produit " + id + " : " + ex.getMessage());
        } finally {
            session.close();
        }
    }

}
