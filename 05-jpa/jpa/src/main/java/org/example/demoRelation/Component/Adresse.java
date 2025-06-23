package org.example.demoRelation.Component;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@Builder
@Embeddable
public class Adresse {
    private String ville;
    private String pays;
    private int codePostal;

    public Adresse(String ville, String pays, int codePostal){
        super();
        this.ville = ville;
        this.pays = pays;
        this.codePostal = codePostal;
    }
//
}
