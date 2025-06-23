package org.example.demoRelation.Heritage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

@Inheritance(strategy = InheritanceType.JOINED)
// Pour le TABLE_PER_CLASS il faut utiliser le  @GeneratedValue(strategy = GenerationType.AUTO pour que JPA puisse avoir des id biens différents avoit des liste set sans id identique

public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    protected String lastname;
    protected String firstname;
}
