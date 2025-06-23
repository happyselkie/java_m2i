package org.example.demoRelation.OneToMany;


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
public class Professeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="idDepartement")
    private Departement departement;

    @Override
    public String toString() {
        return "Professeur{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
