package org.example.demos.repository;

import org.hibernate.Session;
import org.example.demos.entity.Person;

import java.util.List;

public class PersonDAO {

   private Session session;

    public PersonDAO(Session session) {
        this.session = session;
    }

    public Person findById(int id) {
        return session.get(Person.class, id);
    }

    public List<Person> findAll() {
        return session.createQuery("select p from Person p", Person.class).list();
        //return session.createCriteria(Person.class).list();
    }

    public Person save(Person person) {
        session.beginTransaction();
        session.saveOrUpdate(person);
        session.getTransaction().commit();

        return person;
    }

    public boolean delete(Person person) {
        session.beginTransaction();
        session.delete(person);
        session.getTransaction().commit();
        return true;
    }

}
