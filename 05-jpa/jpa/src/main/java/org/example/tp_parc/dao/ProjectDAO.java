package org.example.tp_parc.dao;

import org.example.tp_parc.entity.Computer;
import org.example.tp_parc.entity.Project;

import java.util.List;

public class ProjectDAO extends BaseDAO<Project> {

    public List<Project> getAll(){
        return em.createQuery("SELECT p FROM Project p", Project.class).getResultList();
    }

    public void addComputerToProject(int id,Computer computer) {
        em.getTransaction().begin();
        Project p = em.find(Project.class, id);
        p.addComputer(computer);
        em.getTransaction().commit();
    }

    public void removeComputer(int id,Computer computer) {
        em.getTransaction().begin();
        Project p = em.find(Project.class, id);
        p.removeComputer(computer);
        em.getTransaction().commit();
    }


}
