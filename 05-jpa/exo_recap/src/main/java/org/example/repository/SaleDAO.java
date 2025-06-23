package org.example.repository;

import org.example.entity.Sale;
import org.example.enums.SaleStatus;
import org.example.util.SessionFactorySingleton;

import javax.persistence.TypedQuery;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SaleDAO extends BaseDAO<Sale> {

    public SaleDAO() {
        super(SessionFactorySingleton.getSessionFactory(), Sale.class);
    }

    @Override
    public List<Sale> get() {
        try{
            session = sessionFactory.openSession();
            List<Sale> sales = session.createQuery("select p from Sale p", Sale.class).getResultList();
            return sales;
        }catch (Exception ex){
            return new ArrayList<>();
        }finally {
            session.close();
        }
    }

    public List<Sale> getByDates (Date start , Date end){
        try{
            session = sessionFactory.openSession();
            TypedQuery<Sale> query = session.createQuery("select s from Sale s where s.saleDate between :start and :end", Sale.class);
            query.setParameter("start",start);
            query.setParameter("end",end);
            return query.getResultList();
        }catch (Exception ex){
            return new ArrayList<>();
        }finally {
            session.close();
        }
    }

    public List<Sale> getByStatus (SaleStatus status){
        try{
            session = sessionFactory.openSession();
            TypedQuery<Sale> query = session.createQuery("select s from Sale s where s.status = :status", Sale.class);
            query.setParameter("status",status);
            return query.getResultList();
        }catch (Exception ex){
            return new ArrayList<>();
        }finally {
            session.close();
        }
    }

    public void changeStatus(Sale sale, SaleStatus newStatus){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            TypedQuery<Sale> query = session.createQuery("update Sale s set s.status = :status where s.idSale = :id", Sale.class);
            query.setParameter("status",newStatus);
            session.update(query);
            session.getTransaction().commit();
        } catch (Exception ex){
            session.getTransaction().rollback();
            System.out.println("Impossible de changer le status de la vente " + sale.getIdSale() + " : " + ex.getMessage());
        }
    }


}
