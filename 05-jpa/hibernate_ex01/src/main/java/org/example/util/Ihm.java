package org.example.util;

import antlr.debug.NewLineEvent;
import org.example.entity.Product;
import org.example.service.ProductService;

import javax.persistence.EntityNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Ihm {
    private static ProductService productService = new ProductService();
    private static Scanner scanner = new Scanner(System.in);

    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("*********************** MAGASIN **************************");
            System.out.println("*   [1] Ajouter un produit                               *");
            System.out.println("*   [2] Modifier un produit                              *");
            System.out.println("*   [3] Supprimer un produit                             *");
            System.out.println("*   [4] Voir tous les produits                           *");
            System.out.println("*   [5] Voir tous les produits par marque                *");
            System.out.println("*   [6] Voir tous les entre deux dates                   *");
            System.out.println("*   [7] Voir le prix moyens                              *");
            System.out.println("*   [6] Modifier les images                              *");
            System.out.println("*   [7] Modifier les commentaires                        *");
            System.out.println("*   [0] Quitter                                          *");
            System.out.print("============================ Choix : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    displayAll();
                    break;
                case 5:
                    displayByBrand();
                    break;
                case 6:
                    displayByDate();
                    break;
                case 7:
                    displayAvgPrice();
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

    private static void createProduct() {
        System.out.print("Nom : ");
        String name = scanner.nextLine();
        System.out.print("Marque : ");
        String brand = scanner.nextLine();
        System.out.print("Référence : ");
        String ref = scanner.nextLine();
        System.out.print("Prix  : ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Stock  : ");
        int stock = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Date d'achat (dd/MM/yyyy) : ");
        String dateString = scanner.nextLine();

        java.sql.Date purchaseDate = new DateChecker().dateToSqlDate(dateString);

       Product newProduct =  productService.create(name, brand, ref, price, stock, purchaseDate);
       System.out.println("Nouveau produit : "+newProduct.getName());
    }

    private static void updateProduct() {
        System.out.println("Saisir l'id du produit : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Product product;

        try{
            product = productService.getById(id);
        } catch (EntityNotFoundException e) {
            System.out.println("Produit n'existe pas !");
            return;
        }

        new IhmUpdateProduct(scanner, product, productService).start();
    }

    private static void deleteProduct() {
        System.out.println("Saisir l'id du produit : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Product product;

        try{
            product = productService.getById(id);
        } catch (EntityNotFoundException e) {
            System.out.println("Produit n'existe pas !");
            return;
        }

        productService.delete(id);
    }

    private static void displayAll() {

        List<Product> products = productService.getAll();

        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void displayByBrand() {
        System.out.println("Saisir une marque :");
        String brand = scanner.nextLine();

        productService.getByBrand(brand).forEach(System.out::println);
    }

    private static void displayByDate() {
        System.out.println("Saisir une date de début (dd/MM/yyyy) : :");
        String fromString = scanner.nextLine();
        LocalDate from = new DateChecker().checkLocalDate(fromString);

        System.out.println("Saisir une date de fin (dd/MM/yyyy) : :");
        String toString = scanner.nextLine();
        LocalDate to = new DateChecker().checkLocalDate(toString);

        productService.getByDates(from, to).forEach(System.out::println);
    }

    private static void displayAvgPrice() { System.out.println(productService.getAvgPrice()); }





}
