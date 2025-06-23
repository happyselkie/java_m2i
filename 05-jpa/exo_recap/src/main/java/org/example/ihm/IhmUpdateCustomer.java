package org.example.ihm;

import org.example.entity.Customer;
import org.example.service.CustomerService;

public class IhmUpdateCustomer extends Ihm{

    private static Customer customer;
    private static CustomerService customerService;

    public IhmUpdateCustomer(Customer c){
        customer = c;
        customerService = new CustomerService();
    }

    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("*********************** Modifier un client : "+customer.getName()+" ***********************");
            System.out.println("*   Que voulez-vous faire ?                              *");
            System.out.println("*   [1] Modifier le nom                                  *");
            System.out.println("*   [2] Modifier l'adresse                               *");
            System.out.println("*   [3] Modifier l'email                                 *");
            System.out.println("*   [0] Retour au menu de gestion de l'inventaire        *");
            System.out.print("============================ Choix : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    updateName();
                    break;
                case 2:
                    updateAdress();
                    break;
                case 3:
                    updateEmail();
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

    public static void updateName(){
        String name = customer.getName();
        System.out.println("Saisir le nom du client : ");
        customer.setName(scanner.nextLine());
        customerService.update(customer);

        System.out.println("Le nom "+name+ " du client a été modifié en :"+customer.getName());
    }
    public static void updateAdress(){
        String adress = customer.getAddress();
        System.out.println("Saisir l'adresse du client : ");
        customer.setAddress(scanner.nextLine());
        customerService.update(customer);

        System.out.println("L'adresse "+adress+" du client a été modifiée en :"+customer.getAddress());
    }
    public static void updateEmail(){
        String email = customer.getEmail();
        System.out.println("Saisir l'email du client : ");
        customer.setEmail(scanner.nextLine());
        customerService.update(customer);

        System.out.println("L'email "+email+" du client a été modifié en :"+customer.getEmail());
    }

}


