package org.example.demoRelation.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Recette {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @ManyToMany
    @JoinTable(name = "recette_ingredient",
    joinColumns = @JoinColumn(name = "recetteId"),
    inverseJoinColumns = @JoinColumn(name = "ingredientId"))
    private List<Ingredient> ingredients;

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }


}
