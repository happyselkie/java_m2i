package org.example.demos;

import org.example.demos.entity.Person;
import org.example.demos.repository.PersonDAO;
import org.example.demos.util.SessionSingleton;

public class Main {
    public static void main(String[] args) {
        PersonDAO dao = new PersonDAO(SessionSingleton.getSession());


        Person person = Person.builder().name("toto").age(22).build();
        dao.save(person);
    }
}
