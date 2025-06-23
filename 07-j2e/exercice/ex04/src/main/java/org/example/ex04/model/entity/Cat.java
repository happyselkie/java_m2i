package org.example.ex04.model.entity;

import java.time.LocalDate;

public class Cat {
    private String name;
    private String race;
    private String favoriteMeal;
    private LocalDate dateOfBirth;

    public Cat(String name, String race, String favoriteMeal, LocalDate dateOfBirth) {
        this.name = name;
        this.race = race;
        this.favoriteMeal = favoriteMeal;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getFavoriteMeal() {
        return favoriteMeal;
    }

    public void setFavoriteMeal(String favoriteMeal) {
        this.favoriteMeal = favoriteMeal;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
