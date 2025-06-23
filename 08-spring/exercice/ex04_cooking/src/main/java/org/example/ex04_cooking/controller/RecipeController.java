package org.example.ex04_cooking.controller;

import jakarta.validation.Valid;
import org.example.ex04_cooking.entity.Recipe;
import org.example.ex04_cooking.service.CategoryService;
import org.example.ex04_cooking.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class RecipeController {

    private final RecipeService recipeService;
    private final CategoryService categoryService;


    public RecipeController(RecipeService recipeService, CategoryService categoryService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String homePage(){
        return "home";
    }

    @GetMapping("/recipes")
    public String recipesPage(Model model){
        List<Recipe> recipes = recipeService.findAll();
        model.addAttribute("recipes",recipes);
        return "recipes";
    }

    @GetMapping("/recipe/{recipeId}")
    public String recipePage(@PathVariable UUID recipeId, Model model){
        Recipe recipe = recipeService.findById(recipeId);
        model.addAttribute("categories",categoryService.findAll());
        model.addAttribute("recipe",recipe);
        model.addAttribute("type","edit");
        model.addAttribute("action","/recipe/edit");
        return "recipe";
    }

    @GetMapping("/recipe/add")
    public String registerStudentPage(Model model){
        model.addAttribute("categories",categoryService.findAll());
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("type", "add");
        model.addAttribute("action", "/recipe/add");
        return "recipe";
    }

    @PostMapping("/recipe/edit")
    public String editRecipe(@Valid @ModelAttribute Recipe recipe, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "recipe";
        }
        recipeService.update(recipe);
        return "redirect:/recipes";
    }

    @PostMapping("/recipe/add")
    public String addRecipe(@Valid @ModelAttribute Recipe recipe, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "recipe";
        }
        recipeService.save(recipe);
        return "redirect:/recipes";
    }

    @GetMapping("/recipe/delete")
    public String deleteRecipe(@RequestParam("id") UUID recipeId){
        recipeService.delete(recipeService.findById(recipeId));
        return "redirect:/recipes";
    }


}
