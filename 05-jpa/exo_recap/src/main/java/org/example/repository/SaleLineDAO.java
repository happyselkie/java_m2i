package org.example.repository;

import org.example.entity.SaleLine;
import org.example.util.SessionFactorySingleton;

import java.util.ArrayList;
import java.util.List;

public class SaleLineDAO extends BaseDAO<SaleLine> {

    public SaleLineDAO() {
        super(SessionFactorySingleton.getSessionFactory(), SaleLine.class);
    }

    @Override
    public List<SaleLine> get() {
        try{
            session = sessionFactory.openSession();
            List<SaleLine> sales = session.createQuery("select p from SaleLine p", SaleLine.class).getResultList();
            return sales;
        }catch (Exception ex){
            return new ArrayList<>();
        }finally {
            session.close();
        }
    }



}
