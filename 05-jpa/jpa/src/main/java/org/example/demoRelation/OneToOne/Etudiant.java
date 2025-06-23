package org.example.demoRelation.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Etudiant  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;

    @OneToOne
    @JoinColumn(name = "coordonnees_id")
    private Coordonnees coordonnees;
}

