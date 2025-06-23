package org.example.ex04_cooking.controller;

import jakarta.validation.Valid;
import org.example.ex04_cooking.entity.Category;
import org.example.ex04_cooking.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public String categoriesPage(Model model){
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        return "categories";
    }

    @GetMapping("/category/{categoryId}")
    public String categoryPage(@PathVariable UUID categoryId, Model model){
        Category category = categoryService.findById(categoryId);
        model.addAttribute("category",category);
        model.addAttribute("type","edit");
        model.addAttribute("action","/category/edit");
        return "category";
    }

    @GetMapping("/category/add")
    public String addCategoryPage(Model model){
        model.addAttribute("category", new Category());
        model.addAttribute("type", "add");
        model.addAttribute("action", "/category/add");
        return "category";
    }

    @PostMapping("/category/edit")
    public String editCategory(@Valid @ModelAttribute Category category, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "category";
        }
        categoryService.update(category);
        return "redirect:/categories";
    }

    @PostMapping("/category/add")
    public String addCategory(@Valid @ModelAttribute Category category, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "category";
        }
        categoryService.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/category/delete")
    public String deleteCategory(@RequestParam("id") UUID categoryId){
        categoryService.delete(categoryService.findById(categoryId));
        return "redirect:/categories";
    }
}
