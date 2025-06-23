package org.example.tp_parc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.demoRelation.ManyToMany.Recette;

import javax.persistence.*;
import java.util.List;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String model;

    @Embedded
    private Identification identification;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="idProcessor")
    private Processor processor;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="idOs")
    private OperatingSystem operatingSystem;

    @ManyToMany(mappedBy = "computers")
    private List<Project> projects;

    public void removeProject(Project project) {
        projects.remove(project);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "operatingSystem=" + operatingSystem +
                ", processor=" + processor +
                ", identification=" + identification +
                ", model='" + model + '\'' +
                ", id=" + id +
                '}';
    }
}
