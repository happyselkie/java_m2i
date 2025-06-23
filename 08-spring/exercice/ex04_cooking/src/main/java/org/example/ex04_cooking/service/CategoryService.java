package org.example.ex04_cooking.service;

import org.example.ex04_cooking.entity.Category;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CategoryService implements Repository<Category> {

    private final Map<UUID, Category> categories;

    public CategoryService(){
        categories = new HashMap<>();

        Category categoryA = Category.builder()
                .id(UUID.randomUUID())
                .name("Cheese lover")
                .description("With cheese")
                .build();
        Category categoryB = Category.builder()
                .id(UUID.randomUUID())
                .name("Meat lover")
                .description("With meat")
                .build();
        Category categoryC = Category.builder()
                .id(UUID.randomUUID())
                .name("Veggie lover")
                .description("With vegetables")
                .build();
        Category categoryD = Category.builder()
                .id(UUID.randomUUID())
                .name("Pasta lover")
                .description("With pasta")
                .build();

        this.categories.put(categoryA.getId(),categoryA);
        this.categories.put(categoryB.getId(),categoryB);
        this.categories.put(categoryC.getId(),categoryC);
        this.categories.put(categoryD.getId(),categoryD);
    }

    @Override
    public List<Category> findAll() { return this.categories.values().stream().toList(); }

    @Override
    public Category findById(UUID id) { return this.categories.get(id); }

    public Category findByName(String name) {
        for (Category category : this.categories.values()) {
            if (category.getName().equals(name)) {
                return category;
            }
        }
        return null;
    }

    @Override
    public Category save(Category category) {
        category.setId(UUID.randomUUID());
        categories.put(category.getId(),category);
        return category;
    }

    @Override
    public Category update(Category category) {
        for(Map.Entry<UUID, Category> entry : categories.entrySet()){
            if(entry.getKey().equals(category.getId())){
                entry.getValue().setName(category.getName());
                entry.getValue().setDescription(category.getDescription());
            }
        }
        return category;
    }

    @Override
    public boolean delete(Category category) {
        categories.remove(category.getId());
        return false;
    }


}
