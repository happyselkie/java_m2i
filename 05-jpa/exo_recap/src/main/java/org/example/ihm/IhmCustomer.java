package org.example.ihm;

import org.example.entity.Customer;
import org.example.entity.Product;
import org.example.entity.Sale;
import org.example.service.CustomerService;

import javax.persistence.EntityNotFoundException;

public class IhmCustomer extends Ihm {
    private static CustomerService customerService = new CustomerService();

    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("*********************** Gestion des clients **************************");
            System.out.println("*   Que voulez-vous faire ?                              *");
            System.out.println("*   [1] Ajouter un nouveau client                        *");
            System.out.println("*   [2] Modifier les informations de client              *");
            System.out.println("*   [3] Désactiver un client                             *");
            System.out.println("*   [4] Voir les informations de client                  *");
            System.out.println("*   [0] Retour au menu principal                         *");
            System.out.println("*   Choix : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createCustomer();
                    break;
                case 2:
                    updateCustomer();
                    break;
                case 3:
                    desactivateCustomer();
                    break;
                case 4:
                    displayCustomer();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        }
        System.out.println("Retour au menu principal...");
    }

    public static void createCustomer() {
        System.out.println("Saisir le nom du client :");
        String name = scanner.nextLine();

        System.out.println("Saisir l'adresse du client :");
        String address = scanner.nextLine();

        System.out.println("Saisir l'email du client :");
        String email = scanner.nextLine();

        customerService.create(name , address , email);
        System.out.println("Le client a bien été créé");
    }

    public static void updateCustomer() {
        System.out.println("Saisir l'id client :");
        int id = scanner.nextInt();
        scanner.nextLine();

        try {
            Customer customer = customerService.getById(id);
            new IhmUpdateCustomer(customer).start();
        } catch (EntityNotFoundException e){
            System.out.println("Le client n'existe pas !");
        }

    }

    public static void desactivateCustomer() {
        System.out.println("Saisir l'id du client :");
        int id = scanner.nextInt();
        scanner.nextLine();

        try {
            Customer customer = customerService.getById(id);
            customerService.desactiveCustomer(id);
            System.out.println("Le client "+customer.getName()+" a bien été désactivé !");
        } catch (EntityNotFoundException e){
            System.out.println("Le client n'existe pas !");
        }
    }

    public static void displayCustomer() {
        System.out.println("Saisir l'id du client :");
        int id = scanner.nextInt();
        scanner.nextLine();

        try {
            Customer customer = customerService.getById(id);
            System.out.println(customer);
        } catch (EntityNotFoundException e){
            System.out.println("Le client n'existe pas !");
        }

    }
}
