package org.example.repository;

import org.example.entity.ProductPicture;
import org.example.util.SessionFactorySingleton;

import java.util.ArrayList;
import java.util.List;

public class ProductPictureDAO extends BaseDAO<ProductPicture> {

    public ProductPictureDAO() {
        super(SessionFactorySingleton.getSessionFactory(), ProductPicture.class);
    }

    @Override
    public List<ProductPicture> get() {
        try{
            session = sessionFactory.openSession();
            return session.createQuery("select p from ProductPicture p", ProductPicture.class).getResultList();
        }catch (Exception ex){
            return new ArrayList<>();
        }finally {
            session.close();
        }
    }
}
