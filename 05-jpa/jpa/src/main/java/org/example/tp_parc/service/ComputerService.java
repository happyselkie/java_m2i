package org.example.tp_parc.service;

import org.example.tp_parc.dao.ComputerDAO;
import org.example.tp_parc.dao.OperatingSystemDAO;
import org.example.tp_parc.dao.ProcessorDAO;
import org.example.tp_parc.entity.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public class ComputerService {

    private ComputerDAO computerDao;
    private OperatingSystemDAO operatingSystemDAO;
    private ProcessorDAO processorDAO;

    public ComputerService() {
        this.computerDao = new ComputerDAO();
    }

    public Computer create (String model, Identification identification, Processor processor, OperatingSystem operatingSystem) {
        Computer computer = Computer.builder().model(model).identification(identification).processor(processor).operatingSystem(operatingSystem).build();
        return computerDao.save(computer);
    }

    public List<Computer> getAll() { return computerDao.getAll(); }

    public Computer getComputerById(int id) { return computerDao.getById(id, Computer.class); }

    public Computer getComputerByIdentification (Identification identification){ return computerDao.getComputerByIdentification(identification); }

    public List<Computer> getComputersByProcessor (Processor processor){ return computerDao.getComputersByProcessor(processor); }

    public List<Computer> getComputersByOs (OperatingSystem operatingSystem){ return computerDao.getComputersByOs(operatingSystem); }

    public List<Computer> getComputersByModel (String model){
        return computerDao.getComputersByModel(model);
    }

    public void updateComputer (Computer computer) {
        try{
            computerDao.getById(computer.getId(), Computer.class);
            computerDao.update(computer);
        } catch (EntityNotFoundException e){
            System.out.println("L'ordinateur n'existe pas");
        }
    }

    public void deleteComputer(int id) {
        Computer computer = computerDao.getById(id, Computer.class);
        List<Project> projects =  computer.getProjects();
        for (Project project : projects) {
            computer.removeProject(project);
        }
        computerDao.delete(id, Computer.class);
    }
}
