package org.example.util;

import org.example.entity.Product;
import org.example.entity.ProductPicture;
import org.example.service.ProductService;

import java.util.List;
import java.util.Scanner;

public class IhmPicture {
    private Scanner scanner;
    private Product product;
    private String productName;
    private int productId;
    private ProductService productService;

    public IhmPicture(Scanner scanner, Product product, ProductService productService) {
        this.scanner = scanner;
        this.product = product;
        this.productService = productService;
        productName = product.getName();
        productId = product.getId();
    }

    public void start(){
        boolean running = true;
        while (running) {
            System.out.println("******** Modifier les images d'un produit : ("+productName+") *********");
            System.out.println("*   [1] Ajouter une image            *");
            System.out.println("*   [2] Supprimer une image          *");
            System.out.println("*   [3] Voir toutes les images       *");
            System.out.println("*   [0] Retour                       *");
            System.out.print("============================ Choix : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addPicture();
                    break;
                case 2:
                    removePicture();
                    break;
                case 3:
                    displayPictures();
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

    public void addPicture() {
        System.out.println("Saisir l'url de l'image");
        String path = scanner.nextLine();

        productService.addProductPicture(product, path);

        System.out.println("L'image "+path+" à bien été ajoutée au produit "+productName+"!");
    }

    public void removePicture() {
        System.out.println("Saisir l'id de l'image : ");
        int idPicture = scanner.nextInt();
        scanner.nextLine();

        ProductPicture productPicture;
        String path = "";

        try{
            productPicture = productService.getPicture(idPicture);
            path = productPicture.getPath();
        } catch (Exception e){
            System.out.println("L'image "+idPicture+" n'existe pas !");
        }

        productService.deleteProductPicture(idPicture);

        System.out.println("L'image "+path+" du produit "+productName+" a supprimée !");
    }

    public void displayPictures() {
        productService.getProductPictures(productId).forEach(System.out::println);
    }

}
