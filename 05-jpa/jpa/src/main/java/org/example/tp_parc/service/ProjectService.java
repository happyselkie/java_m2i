package org.example.tp_parc.service;

import org.example.tp_parc.dao.ProjectDAO;
import org.example.tp_parc.entity.Computer;
import org.example.tp_parc.entity.Project;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public class ProjectService {
    private ProjectDAO projectDAO;

    public ProjectService() {
        this.projectDAO = new ProjectDAO();
    }

    public Project create (String name, String description) {
        Project project = Project.builder().name(name).description(description).build();
        return projectDAO.save(project);
    }

    public List<Project> getAll() { return projectDAO.getAll();}

    public Project getProjectById(int id) { return projectDAO.getById(id, Project.class); }

    public void updateProject (Project project) {
        try{
            projectDAO.getById(project.getIdProject(), Project.class);
            projectDAO.update(project);
        } catch (EntityNotFoundException e){
            System.out.println("Le projet n'existe pas");
        }
    }

    public void addComputer (int id, Computer computer) {
        projectDAO.addComputerToProject(id, computer);
    }

    public void removeComputer (int id, Computer computer) {
        projectDAO.removeComputer(id, computer);
    }



    public void deleteProject(int id) {
        Project project = projectDAO.getById(id, Project.class);
        List<Computer> computers =  project.getComputers();
        for (Computer computer : computers) {
            project.removeComputer(computer);
        }
        projectDAO.delete(id, Project.class);
    }

}
