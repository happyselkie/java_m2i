package org.example.tp_parc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.demoRelation.OneToMany.Professeur;

import javax.persistence.*;
import java.util.List;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OperatingSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOs;

    private String name;
    private String version;

    @OneToMany(mappedBy = "departement")
    private List<Professeur> professeurs;
}
