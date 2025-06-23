package org.example.tp_parc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProject;

    private String name;
    private String description;


    @ManyToMany
    @JoinTable(name = "project_computer",
            joinColumns = @JoinColumn(name = "projectId"),
            inverseJoinColumns = @JoinColumn(name = "computerId"))
    private List<Computer> computers;

    public void addComputer(Computer computer) {
        computers.add(computer);
    }
    public void removeComputer(Computer computer) {
        computers.remove(computer);
    }
}
