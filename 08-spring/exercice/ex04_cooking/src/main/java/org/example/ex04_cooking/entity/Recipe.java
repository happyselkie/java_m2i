package org.example.ex04_cooking.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecipe;

    private String name;

    private List<String> ingredients;

    private List<String> steps;

    @ManyToOne
    @JoinColumn(name = "idCategory")
    private Category category;
}
