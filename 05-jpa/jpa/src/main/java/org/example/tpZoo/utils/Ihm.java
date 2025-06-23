package org.example.tpZoo.utils;

import org.example.tpZoo.entity.Animal;
import org.example.tpZoo.entity.AnimalDAO;
import org.example.tpZoo.service.AnimalService;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Ihm {
    private final Scanner scanner;
    private static AnimalService animalService = new AnimalService();

    public Ihm() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\n==== GESTION DU ZOO ====");
            System.out.println("1. Ajouter un animal");
            System.out.println("2. Trouver un animal par son ID");
            System.out.println("3. Trouver un animal par son nom");
            System.out.println("4. Trouver la liste des animals en fonction de leur régime alimentaire (MEAT, VEGETABLES, CEREALS)");
            System.out.println("5. Modifier un animal par son ID");
            System.out.println("6. Supprimer un animal");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addAnimal();
                    break;
                case 2:
                    findAnimalById();
                    break;
                case 3:
                    findAnimalsByName();
                    break;
                case 4:
                    findAnimalsByDiet();
                    break;
                case 5:
                    editAnimal();
                    break;
                case 6:
                    deleteAnimal();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        }
        System.out.println("Au revoir !");
    }

    public void addAnimal(){
        System.out.print("Nom : ");
        String animalName = scanner.nextLine();
        System.out.print("age : ");
        int animalAge = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Régime alimentaire : (MEAT, VEGETABLES, CEREALS)");
        String animalDiet = scanner.nextLine();
        boolean validDiet = false;

        for(Diet validDiets : Diet.values()) {
            if(validDiets.name().equals(animalDiet)) validDiet = true;
        }

        while (!validDiet){
            System.out.printf("Erreur, veuillez insérer un régime alimentaire valide (MEAT, VEGETABLES, CEREALS) : ");
            animalDiet = scanner.nextLine();
            for(Diet validDiets : Diet.values()) {
                if(validDiets.name().equals(animalDiet)) validDiet = true;
            }
        }

        boolean validDate = false;
        Date arrival_date = new Date();

        while (!validDate){
            System.out.print("Date d'arrivée (jj-mm-yy) : ");
            String arrivalDate = scanner.nextLine();
            DateFormat df = new SimpleDateFormat("dd-MM-yy");
            try {
                arrival_date = df.parse(arrivalDate);
                validDate = true;
            } catch (ParseException e) {
                System.out.println("Format de la date incorrect. Veuillez insérer une date d'arrivée correcte (jj-mm-yy): ");
            }
        }

        java.sql.Date sqlDate = new java.sql.Date(arrival_date.getTime());

        Animal newAnimal = new Animal();

        try{
            newAnimal =  animalService.createAnimal(animalName, animalAge, animalDiet, sqlDate);
        } catch (Exception e){
            System.out.println("Impossible d'ajouter un animal : " + e.getMessage());
        }

        System.out.println("Nouvel animal : "+ newAnimal);
    }

    public void findAnimalById(){
        System.out.println("Veuillez saisir un ID : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Animal animal = animalService.findById(id);

        System.out.println(animal);
    }

    public void findAnimalsByName(){
        System.out.println("Veuillez saisir un nom : ");
        String animalName = scanner.nextLine();

        List<Animal> animals = animalService.findByName(animalName);

        System.out.println(animals);
    }

    public void findAnimalsByDiet(){
        System.out.println("Veuillez saisir un régime alimentaire  :  (MEAT, VEGETABLES, CEREALS)");
        String animalDiet = scanner.nextLine();
        boolean validDiet = false;

        for(Diet validDiets : Diet.values()) {
            if(validDiets.name().equals(animalDiet)) validDiet = true;
        }

        while (!validDiet){
            System.out.printf("Erreur, veuillez insérer un régime alimentaire valide (MEAT, VEGETABLES, CEREALS) : ");
            animalDiet = scanner.nextLine();
            for(Diet validDiets : Diet.values()) {
                if(validDiets.name().equals(animalDiet)) validDiet = true;
            }
        }

        List<Animal> animals = animalService.findByDiet(Diet.valueOf(animalDiet));

        System.out.println(animals);
    }

    public void editAnimal(){
        System.out.println("Veuillez saisir un ID : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nom : ");
        String animalName = scanner.nextLine();
        System.out.print("age : ");
        int animalAge = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Régime alimentaire : (MEAT, VEGETABLES, CEREALS)");
        String animalDiet = scanner.nextLine();
        boolean validDiet = false;

        for(Diet validDiets : Diet.values()) {
            if(validDiets.name().equals(animalDiet)) validDiet = true;
        }

        while (!validDiet){
            System.out.printf("Erreur, veuillez insérer un régime alimentaire valide (MEAT, VEGETABLES, CEREALS) : ");
            animalDiet = scanner.nextLine();
            for(Diet validDiets : Diet.values()) {
                if(validDiets.name().equals(animalDiet)) validDiet = true;
            }
        }

        boolean validDate = false;
        Date arrival_date = new Date();

        while (!validDate){
            System.out.print("Date d'arrivée (jj-mm-yy) : ");
            String arrivalDate = scanner.nextLine();
            DateFormat df = new SimpleDateFormat("dd-MM-yy");
            try {
                arrival_date = df.parse(arrivalDate);
                validDate = true;
            } catch (ParseException e) {
                System.out.println("Format de la date incorrect. Veuillez insérer une date d'arrivée correcte (jj-mm-yy): ");
            }
        }

        java.sql.Date sqlDate = new java.sql.Date(arrival_date.getTime());

        Animal animal = animalService.findById(id);

        System.out.print("Animal : "+animal);

        animalService.editAnimal(animal, animalName, animalAge, animalDiet, sqlDate);

        System.out.println(" modifié : "+animal);
    }

    public void deleteAnimal(){
        System.out.println("Veuillez saisir un ID : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Animal animal = animalService.findById(id);

        animalService.delete(animal);
        System.out.println(" supprimé : "+animal);
    }
}
