package org.example.ihm;

import org.example.service.ProductService;
import org.example.util.DateChecker;

import java.util.Scanner;

public class Ihm {
    protected static ProductService productService = new ProductService();
    protected static Scanner scanner = new Scanner(System.in);
    protected static DateChecker dateChecker = new DateChecker() {
    };

    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("*********************** Bienvenue dans la gestion du magasin ! **************************");
            System.out.println("*   A quel menu voulez-vous accéder ?                    *");
            System.out.println("*   [1] Gestion de l'inventaire                          *");
            System.out.println("*   [2] Gestion des ventes                               *");
            System.out.println("*   [3] Gestion des clients                              *");
            System.out.println("*   [4] Rapports et analyse                              *");
            System.out.println("*   [0] Quitter                                          *");
            System.out.print("============================ Choix : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    new IhmInventory().start();
                    break;
                case 2:
                    new IhmSales().start();
                    break;
                case 3:
                    new IhmCustomer().start();
                    break;
                case 4:
                    new IhmReports().start();
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

}
