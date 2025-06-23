package org.example.demoRelation.Heritage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Student extends Person {

    private String classroom;
}
