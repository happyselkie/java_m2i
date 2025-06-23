package org.example.ihm;

import org.example.entity.Product;

import javax.persistence.EntityNotFoundException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class IhmStock extends Ihm{

    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("*********************** Gestion des stocks **************************");
            System.out.println("*   Que voulez-vous faire ?                              *");
            System.out.println("*   [1] Voir le stock d'un produit                       *");
            System.out.println("*   [2] Ajouter du stock à un produit                    *");
            System.out.println("*   [3] Voir la moyenne des stocks                       *");
            System.out.println("*   [4] Voir les produits dont le stock est inférieur à  *");
            System.out.println("*   [0] Retour au menu de gestion de l'inventaire        *");
            System.out.print("============================ Choix : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayProductStock();
                    break;
                case 2:
                    updateProductStock();
                    break;
                case 3:
                    getAvgStockByType();
                    break;
                case 4:
                    getUnderAmount();
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

    public static void displayProductStock() {
        System.out.println("Saisir l'id d'un produit");
        int id = scanner.nextInt();
        scanner.nextLine();
        Product product;

        try{
            product = productService.getById(id);
            System.out.println("Le stock du produit "+product.getName()+" est de "+product.getStock());
        } catch (EntityNotFoundException e){
            System.out.println("Le produit n'existe pas !");
        }
    }

    public static void updateProductStock() {
        System.out.println("Saisir l'id d'un produit");
        int id = scanner.nextInt();
        scanner.nextLine();
        Product product;
        try{
            product = productService.getById(id);
            System.out.println("Stock actuel : "+product.getStock()+". Quelle quantité voulez-vous ajouter ? : ");
            int restock = scanner.nextInt();
            scanner.nextLine();

            while(restock <= 0){
                System.out.println("Erreur, veuillez saisir un montant positif. Quelle quantité voulez-vous ajouter ?");
                restock = scanner.nextInt();
                scanner.nextLine();
            }

            product.setStock(product.getStock() + restock);

            Date restockDate = dateChecker.nowToSqlDate();
            product.setRestockDate(restockDate);

            productService.update(product);

            System.out.println("Le stock du produit "+product.getName()+" a bien été modifié à la date d'aujourd'hui");
        } catch (EntityNotFoundException e){
            System.out.println("Le produit n'existe pas !");
        }
    }

    public static void getAvgStockByType() {
        System.out.println("Moyenne du stock des produits alimentaires   : "+productService.getAvgStockFoods());
        System.out.println("Moyenne du stock des produits électroniques  : "+productService.getAvgStockElectronics());
        System.out.println("Moyenne du stock des produits vestimentaires : "+productService.getAvgStockClothes());
        System.out.println("Moyenne totale : "+ (productService.getAvgStockFoods()+productService.getAvgStockElectronics()+productService.getAvgStockClothes()));
    }

    public static void getUnderAmount() {
        System.out.println("Saisir le montant : ");
        int montant = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Liste des produits dont le stock est inférieur à "+montant+": ");

        List<Product> products = productService.getUnderStockAmount(montant);
        for(Product product : products){
            System.out.println(product);
        }
    }



}
