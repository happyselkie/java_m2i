package org.example.ihm;

import org.example.enums.ClotheCategory;
import org.example.enums.ClotheSize;
import org.example.util.EnumChecker;

import java.sql.Date;
import java.util.InputMismatchException;

public class IhmCreateProduct extends Ihm{

    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("*********************** Créer un produit **************************");
            System.out.println("*   Quel type de produit voulez-vous ajouter ?           *");
            System.out.println("*   [1] Un produit alimentaire                           *");
            System.out.println("*   [2] Un produit électronique                          *");
            System.out.println("*   [3] Un produit de mode                               *");
            System.out.println("*   [0] Retour au menu de gestion de l'inventaire        *");
            System.out.print("============================ Choix : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createProduct("food");
                    break;
                case 2:
                    createProduct("electronic");
                    break;
                case 3:
                    createProduct("cloth");
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        }
        System.out.println("Retour au menu de gestion de l'inventaire...");
    }

    public static void createProduct(String discriminator) {
        System.out.println("Référence du produit : ");
        String ref = scanner.nextLine();

        System.out.println("Nom du produit : ");
        String name = scanner.nextLine();

        System.out.println("Description du produit : ");
        String description = scanner.nextLine();

        System.out.println("Prix du produit : ");
        double prix = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Stock du produit : ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Date du dernier stock : ");
        String date = scanner.nextLine();
        Date restockDate = dateChecker.dateToSqlDate(date);

        switch(discriminator) {
            case "food":
                System.out.println("Date d'expiration : ");
                String expiration = scanner.nextLine();
                Date expirationDate = dateChecker.dateToSqlDate(date);

                productService.createFood(ref, name, description, prix, stock, restockDate, expirationDate);
                break;
            case "electronic":
                System.out.println("Autonomie : ");
                int autonomie = scanner.nextInt();
                scanner.nextLine();

                productService.createElectronic(ref, name, description, prix, stock, restockDate, autonomie);
                break;
            case "cloth":
                System.out.println("Catégorie (\"men\", \"women\" ou \"children\") : ");
                boolean validCat = false;
                ClotheCategory clotheCategory = null;

                while(!validCat) {
                    try{
                        clotheCategory = EnumChecker.getCategory(scanner.nextLine().toLowerCase());
                        validCat = true;
                    } catch (InputMismatchException e){
                        System.out.println(e.getMessage()+ ", veuillez insérer une catégorie valide (\"men\", \"women\" ou \"children\") :");
                    }
                }

                System.out.println("Taille (\"xs\", \"s\", \"m\", \"l\", \"xl\") : ");
                boolean validSize = false;
                ClotheSize clotheSize = null;

                while(!validSize) {
                    try{
                        clotheSize = EnumChecker.getSize(scanner.nextLine().toLowerCase());
                        validSize = true;
                    } catch (InputMismatchException e){
                        System.out.println(e.getMessage()+ ", veuillez insérer une taille valide (\"xs\", \"s\", \"m\", \"l\", \"xl\") :");
                    }
                }

                productService.createClothe(ref, name,description,prix,stock, restockDate, clotheCategory, clotheSize);
        }
    }

}
