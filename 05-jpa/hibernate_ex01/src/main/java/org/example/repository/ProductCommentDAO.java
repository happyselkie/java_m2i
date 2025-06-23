package org.example.repository;

import org.example.entity.ProductComment;
import org.example.entity.ProductPicture;
import org.example.util.SessionFactorySingleton;

import java.util.ArrayList;
import java.util.List;

public class ProductCommentDAO extends BaseDAO<ProductComment> {

    public ProductCommentDAO() {
        super(SessionFactorySingleton.getSessionFactory(), ProductComment.class);
    }

    @Override
    public List<ProductComment> get() {
        try{
            session = sessionFactory.openSession();
            return session.createQuery("select p from ProductComment p", ProductComment.class).getResultList();
        }catch (Exception ex){
            return new ArrayList<>();
        }finally {
            session.close();
        }
    }


}
