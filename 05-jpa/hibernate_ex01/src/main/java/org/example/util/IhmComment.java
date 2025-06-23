package org.example.util;

import org.example.entity.Product;
import org.example.entity.ProductComment;
import org.example.entity.ProductPicture;
import org.example.service.ProductService;

import java.util.Scanner;

public class IhmComment {
    private static Scanner scanner;
    private static Product product;
    private static String productName;
    private static int productId;
    private static ProductService productService;

    public IhmComment(Scanner scanner, Product product, ProductService productService) {
        this.scanner = scanner;
        this.product = product;
        this.productService = productService;
        productName = product.getName();
        productId = product.getId();
    }

    public static void start(){
        boolean running = true;
        while (running) {
            System.out.println("******** Modifier les commentaires d'un produit : ("+productName+") *********");
            System.out.println("*   [1] Ajouter un commentaire            *");
            System.out.println("*   [2] Supprimer un commentaire          *");
            System.out.println("*   [3] Voir tous les commentaires        *");
            System.out.println("*   [0] Retour                            *");
            System.out.print("============================ Choix : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addComment();
                    break;
                case 2:
                    removeComment();
                    break;
                case 3:
                    displayComments();
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

    public static void addComment() {
        System.out.println("Saisir le contenu : ");
        String content = scanner.nextLine();

        System.out.print("Date de publication (dd/MM/yyyy) : ");
        String dateString = scanner.nextLine();

        java.sql.Date publisedDate = new DateChecker().dateToSqlDate(dateString);

        System.out.println("Note :");
        float note = scanner.nextFloat();
        scanner.nextLine();

        productService.addProductComment(product, content, publisedDate, note);

        System.out.println("Le commentaire à bien été ajoutée au produit "+productName+"!");
    }

    public static void removeComment() {
        System.out.println("Saisir l'id du commentaire : ");
        int idComment = scanner.nextInt();
        scanner.nextLine();

        ProductComment productComment;

        try{
            productComment = productService.getComment(idComment);
        } catch (Exception e){
            System.out.println("Le commentaire "+idComment+" n'existe pas !");
        }

        productService.deleteProductComment(idComment);

        System.out.println("Le commentaire du produit "+productName+" a été supprimée !");
    }

    public static void displayComments() {
        product.getProductComments().forEach(System.out::println);
    }
}
