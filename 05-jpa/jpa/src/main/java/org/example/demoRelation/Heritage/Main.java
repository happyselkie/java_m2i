package org.example.demoRelation.Heritage;

import org.example.demoRelation.Heritage.entity.Student;
import org.example.demoRelation.Heritage.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");
        EntityManager em = emf.createEntityManager();

         Student student = Student.builder().firstname("toto").lastname("titi").classroom("classe A").build();
         Teacher teacher = Teacher.builder().firstname("tata").lastname("tutu").course("anglais").build();

         em.getTransaction().begin();
         em.persist(student);
         em.persist(teacher);
         em.getTransaction().commit();
    }
}
