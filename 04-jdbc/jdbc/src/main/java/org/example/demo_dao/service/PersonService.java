package org.example.demo_dao.service;

import org.example.demo_dao.dao.PersonDao;
import org.example.demo_dao.model.Person;
import org.example.demo_dao.util.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PersonService {

    private PersonDao personDao;
    private Connection connection;

    public PersonService() {
        try{
            connection = new DatabaseManager().getConnection();
            personDao =  new PersonDao(connection);
        } catch (SQLException e){
            System.out.println("Connexion impossible : "+e.getMessage());
        }
    }

    public boolean createPerson(String firstname, String lastname){
        Person person = new Person(firstname, lastname);

        try{
            if(personDao.save(person)) return true;
        } catch (SQLException e){
            System.out.println("Impossible d'enregistrer : "+e.getMessage());
        }
        return false;
    }

    public boolean updatePerson(Person person){
        try{
            if(personDao.update(person)) return true;
        } catch (SQLException e){
            System.out.println("Impossible de modifier : "+e.getMessage());
        }
        return false;
    }

    public Person getPerson(int id){
        try{
           return personDao.get(id);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean deletePerson(int id){
        Person person = null;
        try{
            person = personDao.get(id);
            if(person != null) return personDao.delete(person);
        } catch (SQLException e){
            System.out.println("Impossible de supprimer : "+e.getMessage());
        }
        return false;
    }


    public List<Person> getAllPerson(){
        try {
            return personDao.get();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
