package org.example.ihm;


import org.example.entity.Product;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public class IhmInventory extends Ihm{

    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("*********************** Gestion de l'inventaire **************************");
            System.out.println("*   Que voulez-vous faire ?                              *");
            System.out.println("*   [1] Ajouter un produit                               *");
            System.out.println("*   [2] Modifier un produit                              *");
            System.out.println("*   [3] Désactiver un produit                            *");
            System.out.println("*   [4] Consulter tous les produits                      *");
            System.out.println("*   [5] Consulter les produits alimentaires              *");
            System.out.println("*   [6] Consulter les produits électroniques             *");
            System.out.println("*   [7] Consulter les produits vestimentaires            *");
            System.out.println("*   [8] Gestion des stocks                               *");
            System.out.println("*   [0] Retour au menu principal                         *");
            System.out.print("============================ Choix : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    new IhmCreateProduct().start();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    desactivateProduct();
                    break;
                case 4:
                    displayAll();
                    break;
                case 5:
                    displayFoods();
                    break;
                case 6:
                    displayElectronics();
                    break;
                case 7:
                    displayClothes();
                    break;
                case 8:
                    new IhmStock().start();
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

    public static void updateProduct() {
        System.out.println("Saisir la référence du produit :");
        String ref = scanner.nextLine();

        try {
            Product product = productService.getByRef(ref);
            new IhmUpdateProduct(product).start();
        } catch (EntityNotFoundException e){
            System.out.println("Le produit n'existe pas !");
        }
    }

    public static void desactivateProduct() {
        System.out.println("Saisir la référence du produit :");
        String ref = scanner.nextLine();

        try {
            Product product = productService.getByRef(ref);
            product.setActive(false);
            productService.update(product);
            System.out.println("Le produit "+product.getName()+" a bien été désactivé !");
        } catch (EntityNotFoundException e){
            System.out.println("Le produit n'existe pas !");
        }
    }

    public static void displayAll() {
        productService.getAll().forEach(System.out::println);
    }

    public static void displayFoods() {
        productService.getFoods().forEach(System.out::println);
    }

    public static void displayElectronics() {
        productService.getElectronics().forEach(System.out::println);
    }
    public static void displayClothes() {
        productService.getClothes().forEach(System.out::println);
    }
}
