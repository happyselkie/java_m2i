package org.example.demoRelation.Component;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Agence {
    @Id
    private String code;
    private String libelle;

    @Embedded
    private Adresse adresse;
    public Agence() { }
    public Agence(String code, String libelle,
                  Adresse adresse) {
        super();
        this.code = code;
        this.libelle = libelle;
        this.adresse = adresse;
    }
//
}
