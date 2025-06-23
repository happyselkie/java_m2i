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
public class Coordonnees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int coordonnees_id;

    private String adresse;
    private int codePostal;

    @OneToOne(mappedBy = "coordonnees")
    private Etudiant etudiant;

    @Override
    public String toString() {
        return "Coordonnees{" +
                "coordonnees_id=" + coordonnees_id +
                ", adresse='" + adresse + '\'' +
                ", codePostal=" + codePostal +
                '}';
    }
}
