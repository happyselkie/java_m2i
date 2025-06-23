package org.example.repository;

import org.example.entity.Customer;
import org.example.entity.Product;
import org.example.util.SessionFactorySingleton;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO extends BaseDAO<Customer> {

    public CustomerDAO() {
        super(SessionFactorySingleton.getSessionFactory(), Customer.class);
    }

    @Override
    public List<Customer> get() {
        try{
            session = sessionFactory.openSession();
            List<Customer> customers = session.createQuery("select c from Customer c", Customer.class).getResultList();
            return customers;
        }catch (Exception ex){
            return new ArrayList<>();
        }finally {
            session.close();
        }
    }

    public Customer getByEmail(String email) {
        try{
            session = sessionFactory.openSession();
            TypedQuery<Customer> query = session.createQuery("select c from Customer c where c.email=:email", Customer.class);
            query.setParameter("email", email);
            return query.getSingleResult();
        } catch (Exception ex){
            return null;
        } finally {
            session.close();
        }
    }

    public void desactivateCustomer(int id){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            TypedQuery<Customer> query = session.createQuery("update Customer c set c.active = false where c.idCustomer = :id", Customer.class);
            query.setParameter("id", id);
            session.update(query);
            session.getTransaction().commit();
        } catch (Exception ex){
            session.getTransaction().rollback();
            System.out.println("Impossible de désactiver le client " + id + " : " + ex.getMessage());
        } finally {
            session.close();
        }
    }

}
