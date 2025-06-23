package org.example.tp_parc.dao;

import org.example.tp_parc.entity.Computer;
import org.example.tp_parc.entity.Identification;
import org.example.tp_parc.entity.OperatingSystem;
import org.example.tp_parc.entity.Processor;

import javax.persistence.TypedQuery;
import java.util.List;

public class ComputerDAO extends BaseDAO<Computer> {

    public List<Computer> getAll(){
        return em.createQuery("SELECT c FROM Computer c", Computer.class).getResultList();
    }

    public Computer getComputerByIdentification (Identification identification){
        TypedQuery<Computer> query = em.createQuery("select c from Computer c where c.identification = :identification", Computer.class);
        query.setParameter("identification",identification);
        return query.getSingleResult();
    }

    public List<Computer> getComputersByModel (String model){
        TypedQuery<Computer> query = em.createQuery("select c from Computer c where c.model = :model", Computer.class);
        query.setParameter("model",model);
        return query.getResultList();
    }

    public List<Computer> getComputersByProcessor (Processor processor){
        TypedQuery<Computer> query = em.createQuery("select c from Computer c where c.processor = :processor", Computer.class);
        query.setParameter("processor",processor);
        return query.getResultList();
    }

    public List<Computer> getComputersByOs (OperatingSystem operatingSystem){
        TypedQuery<Computer> query = em.createQuery("select c from Computer c where c.operatingSystem = :operatingSystem", Computer.class);
        query.setParameter("operatingSystem",operatingSystem);
        return query.getResultList();
    }
}
