package org.example.tpProduct.utils;

import org.example.tpProduct.entity.Product;
import org.example.tpProduct.entity.Product_Electronic;
import org.example.tpProduct.entity.Product_Food;
import org.example.tpProduct.entity.Product_Housing;
import org.example.tpProduct.service.ProductService;

import javax.persistence.EntityNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ihm {

    private static ProductService productService = new ProductService();
    private static Scanner scanner = new Scanner(System.in);

    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("*********************** MAGASIN **************************");
            System.out.println("*   [1] Ajouter un article périssable                            *");
            System.out.println("*   [2] Ajouter un article électronique                          *");
            System.out.println("*   [3] Ajouter un article décoratif                             *");
            System.out.println("*   [4] Voir tous les articles                                   *");
            System.out.println("*   [5] Voir tous les article périssables                        *");
            System.out.println("*   [6] Voir tous les article électronique                       *");
            System.out.println("*   [7] Voir tous les articles décoratifs                        *");
            System.out.println("*   [8] Modifier un article                                      *");
            System.out.println("*   [9] Supprimer un article                                     *");
            System.out.println("*   [0] Quitter                                                  *");
            System.out.print("============================ Choix : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createFood();
                    break;
                case 2:
                    createElectronic();
                    break;
                case 3:
                    createHousing();
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
                    displayHousings();
                    break;
                case 8:
                    updateProduct();
                    break;
                case 9:
                    deleteProduct();
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

    private static void createFood() {
        System.out.print("Nom : ");
        String name = scanner.nextLine();
        System.out.print("Prix  : ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        boolean validDate = false;
        Date expirationDate = new Date();

        while (!validDate){
            System.out.print("Date d'expiration (dd/MM/yyyy) : ");
            String dateString = scanner.nextLine();
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            try {
                expirationDate = df.parse(dateString);
                validDate = true;
            } catch (ParseException e) {
                System.out.println("Format de la date incorrect. Veuillez insérer une date d'expiration correcte (dd/MM/yyyy): ");
            }
        }

        productService.createFoods(name, price, expirationDate);
    }

    private static void createElectronic() {
        System.out.print("Nom ");
        String name = scanner.nextLine();
        System.out.print("Prix  : ");
        double price = scanner.nextDouble();
        System.out.print("Autonomie (en h)  : ");
        int autonomy = scanner.nextInt();
        scanner.nextLine();


        productService.createElectronic(name, price, autonomy);
    }

    private static void createHousing() {
        System.out.print("Nom ");
        String name = scanner.nextLine();
        System.out.print("Prix  : ");
        double price = scanner.nextDouble();
        System.out.print("Hauteur : ");
        double height = scanner.nextDouble();
        System.out.print("Largeur : ");
        double width = scanner.nextDouble();



        productService.createHousing(name, price, height,width);
    }

    private static void displayAll() {
        for (Product p : productService.getAllProducts()) {
            System.out.println(p);
        }
    }

    private static void displayFoods() {
        for (Product p : productService.getFoods()) {
            System.out.println(p);
        }
    }

    private static void displayElectronics() {
        for (Product p : productService.getEletronics()) {
            System.out.println(p);
        }
    }

    private static void displayHousings() {
        for (Product p : productService.getHousings()) {
            System.out.println(p);
        }
    }

    private static void updateProduct() {
        System.out.println("Saisir l'id du produit à modifier :");
        int id = scanner.nextInt();
        scanner.nextLine();
        Product product = null;

        try {
            product = productService.getProductById(id);
        } catch (EntityNotFoundException e) {
            System.out.println("Il n'y a pas d'article avec cet id");
        }

        System.out.println("Saisir le nom :");
        product.setName(scanner.nextLine());
        System.out.println("Saisir le prix :");
        product.setPrice(scanner.nextDouble());

        if(product instanceof Product_Food){
            boolean validDate = false;
            Date expirationDate = new Date();

            while (!validDate){
                System.out.print("Date d'expiration : (dd/MM/yyyy)");
                String dateString = scanner.nextLine();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    expirationDate = df.parse(dateString);
                    validDate = true;
                } catch (ParseException e) {
                    System.out.println("Format de la date incorrect. Veuillez insérer une date d'expiration correcte (dd/MM/yyyy) ");
                }
            }
            ((Product_Food) product).setExpirationDate(expirationDate);
        } else if (product instanceof Product_Electronic) {
            System.out.println("Saisir l'autonomie (en h) :");
            ((Product_Electronic) product).setAutonomy(scanner.nextInt());
            scanner.nextLine();
        } else{
            System.out.println("Saisir la hauteur :");
            ((Product_Housing) product).setHeight(scanner.nextDouble());
            System.out.println("Saisir la largeur :");
            ((Product_Housing) product).setWidth(scanner.nextDouble());
        }

        productService.updateProduct(product);

        System.out.println("Le produit a bien été modifié ! ");
    }

    private static void deleteProduct() {
        System.out.print("ID de l'article à supprimer : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        productService.deleteProduct(id);
        System.out.println("Article supprimé avec succès !");
    }
}
