package org.example.util;

import org.example.entity.Product;
import org.example.service.ProductService;


import java.util.Scanner;

public class IhmUpdateProduct {
    private static Scanner scanner;
    private static Product product;
    private static ProductService productService;

    public IhmUpdateProduct(Scanner scanner, Product product, ProductService productService) {
        this.scanner = scanner;
        this.product = product;
        this.productService = productService;
    }

    public static void start(){
        boolean running = true;
        while (running) {
            System.out.println("******** Modifier un produit *********");
            System.out.println("*   [1] Modifier le nom              *");
            System.out.println("*   [2] Modifier la marque           *");
            System.out.println("*   [3] Modifier le prix             *");
            System.out.println("*   [4] Modifier la référence        *");
            System.out.println("*   [5] Modifier le stock            *");
            System.out.println("*   [6] Modifier la date d'achat     *");
            System.out.println("*   [7] Modifier les images          *");
            System.out.println("*   [8] Modifier les commentaires    *");
            System.out.println("*   [0] Retour                       *");
            System.out.print("============================ Choix : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    updateName();
                    break;
                case 2:
                    updateBrand();
                    break;
                case 3:
                    updatePrice();
                    break;
                case 4:
                    updateRef();
                    break;
                case 5:
                    updateStock();
                    break;
                case 6:
                    updateDate();
                    break;
                case 7:
                    updatePictures();
                    break;
                case 8:
                    updateComments();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        }
        System.out.println("Retour...");
    }

    public static void updateName() {
        String name = product.getName();
        System.out.println("Saisir le nouveau nom :");
        product.setName(scanner.nextLine());
        productService.update(product);
        System.out.println("Le nom "+name+"du produit "+product.getName()+" a bien été modifié en "+product.getName()+" !");
    }

    public static void updateBrand() {
        String brand = product.getBrand();
        System.out.println("Saisir la nouvelle marque :");
        product.setBrand(scanner.nextLine());
        productService.update(product);
        System.out.println("La marque "+brand+" du produit "+product.getName()+" a été modifiée en "+product.getBrand()+" !");
    }

    public static void updatePrice() {
        double price = product.getPrice();
        System.out.println("Saisir le prix :");
        product.setPrice(scanner.nextDouble());
        productService.update(product);
        System.out.println("Le prix " + price + " du produit "+product.getName()+" a été modifié en "+product.getPrice()+" !");
    }

    public static void updateRef() {
        String ref = product.getRef();
        System.out.println("Saisir la ref :");
        product.setRef(scanner.nextLine());
        productService.update(product);
        System.out.println("La réference "+ ref + " du produit "+product.getName()+" a été modifiée en "+product.getRef()+" !");
    }

    public static void updateStock() {
        int stock = product.getStock();
        System.out.println("Saisir le stock :");
        product.setStock(scanner.nextInt());
        scanner.nextLine();
        productService.update(product);
        System.out.println("Le stock ("+stock+") du produit "+product.getName()+" a été modifié en "+product.getStock()+" !");
    }

    public static void updateDate() {
        System.out.print("Nouvelle date d'achat (dd/MM/yyyy) : ");
        String dateString = scanner.nextLine();

        java.sql.Date purchaseDate = new DateChecker().dateToSqlDate(dateString);

        product.setPurchaseDate(purchaseDate);
        System.out.println("La date d'achat du produit "+product.getName()+" a été modifiée en "+purchaseDate+" !");
    }

    public static void updatePictures() {
        new IhmPicture(scanner, product, productService).start();
    }

    public static void updateComments() {
        new IhmComment(scanner, product, productService).start();
    }

}

