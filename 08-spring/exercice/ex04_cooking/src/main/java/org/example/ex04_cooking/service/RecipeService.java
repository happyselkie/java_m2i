package org.example.ex04_cooking.service;


import org.example.ex04_cooking.entity.Recipe;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class RecipeService implements Repository<Recipe> {
    private final Map<UUID, Recipe> recipes;
    private final CategoryService categoryService;

    public RecipeService(CategoryService categoryService){
        recipes = new HashMap<>();
        this.categoryService = categoryService;

        Recipe recipeA = Recipe.builder()
                .id(UUID.randomUUID())
                .name("Omelette")
                .categoryId(categoryService.findByName("Cheese lover").getId())
                .ingredients(List.of("Cheese", "Egg", "Milk"))
                .steps(List.of("Step 1", "Step 2", "Step 3"))
                .build();

        this.recipes.put(recipeA.getId(),recipeA);
    }

    @Override
    public List<Recipe> findAll() { return this.recipes.values().stream().toList(); }

    @Override
    public Recipe findById(UUID id) {return this.recipes.get(id);}

    @Override
    public Recipe save(Recipe recipe){
        recipe.setId(UUID.randomUUID());
        recipes.put(recipe.getId(),recipe);
        return recipe;
    }


    @Override
    public Recipe update(Recipe recipe) {
        recipes.get(recipe.getId()).setName(recipe.getName());
        recipes.get(recipe.getId()).setCategoryId(recipe.getCategoryId());
        recipes.get(recipe.getId()).setIngredients(recipe.getIngredients());
        recipes.get(recipe.getId()).setSteps(recipe.getSteps());
        return recipe;
    }

    @Override
    public boolean delete(Recipe recipe) {
        recipes.remove(recipe.getId());
        return true;
    }

}
