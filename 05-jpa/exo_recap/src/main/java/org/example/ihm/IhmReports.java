package org.example.ihm;

import org.example.entity.Customer;
import org.example.entity.Product;
import org.example.entity.Sale;
import org.example.service.CustomerService;
import org.example.service.SaleService;

import javax.persistence.EntityNotFoundException;
import java.sql.Date;

public class IhmReports extends Ihm {

    private static CustomerService customerService;
    private static SaleService saleService;

    public IhmReports() {
        customerService = new CustomerService();
        saleService = new SaleService();
    }

    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("*********************** Rapports et analyses **************************");
            System.out.println("*   Que voulez-vous faire ?                              *");
            System.out.println("*   [1] Historique d'achat d'un client                   *");
            System.out.println("*   [2] Voir les ventes d'une période                    *");
            System.out.println("*   [3] Voir les ventes par produit                      *");
            System.out.println("*   [0] Retour au menu de gestion de l'inventaire        *");
            System.out.print("============================ Choix : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayCustomerSales();
                    break;
                case 2:
                    displaySalesByDates();
                    break;
                case 3:
                    displaySalesByProduct();
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

    public static void displayCustomerSales() {
        System.out.println("Saisir l'id du client :");
        int id = scanner.nextInt();
        scanner.nextLine();

        try {
            Customer customer = customerService.getById(id);

            for (Sale sale : customer.getSales()) {
                System.out.println(sale);
            }
        } catch (EntityNotFoundException e){
            System.out.println("Le client n'existe pas !");
        }
    }

    public static void displaySalesByDates() {
        System.out.println("Saisir la date de début (dd/MM/yyyy):");
        String dateStartString = scanner.nextLine();

        Date startDate = dateChecker.dateToSqlDate(dateStartString);

        System.out.println("Saisir la date de fin (dd/MM/yyyy):");
        String dateEndString = scanner.nextLine();

        Date endDate = dateChecker.dateToSqlDate(dateEndString);

        saleService.getByDates(startDate, endDate).forEach(System.out::println);
    }

    public static void displaySalesByProduct() {
        System.out.println("Saisir la référence du produit :");
        String ref = scanner.nextLine();

        Product product = null;

        boolean validRef = false;

        while (!validRef) {
            try {
                product = productService.getByRef(ref);
                validRef = true;
            } catch (EntityNotFoundException e){
                System.out.println("Le produit n'existe pas, veuillez saisir une ref associée à un produit :");
            }
        }

        product.getSaleLines().forEach(System.out::println);
    }
}
