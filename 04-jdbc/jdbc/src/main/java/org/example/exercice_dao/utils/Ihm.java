package org.example.exercice_dao.utils;

import org.example.exercice_dao.model.Account;
import org.example.exercice_dao.model.Customer;
import org.example.exercice_dao.service.BankService;

import java.util.Scanner;

public class Ihm {
    private static BankService bankService = new BankService();
    private static Scanner scanner = new Scanner(System.in);

    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("1. Ajouter un client");
            System.out.println("2. Modifier un client");
            System.out.println("3. Supprimer un client");
            System.out.println("4. Effectuer un dépôt");
            System.out.println("5. Effectuer un retrait");
            System.out.println("5. Quitter");
            System.out.print("Choix : ");

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
                    deleteCustomer();
                    break;
                case 4:
                    makeDeposit();
                    break;
                case 5:
                    makeWithdrawal();
                    break;
                case 6:
                    getAccount();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        }
        System.out.println("Au revoir !");
    }

    private static void createCustomer() {
        System.out.print("Nom  : ");
        String firstName = scanner.nextLine();
        System.out.print("Prenom : ");
        String lastName = scanner.nextLine();
        System.out.print("Téléphone : ");
        String phone = scanner.nextLine();


        bankService.createCustomer(firstName,lastName,phone);
    }

    private static void updateCustomer() {
        System.out.print("ID du client à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Customer customer = bankService.getCustomer(id);
        if (customer == null) {
            System.out.println("Utilisateur non trouvé !");
            return;
        }

        System.out.print("Nouveau nom : ");
        String newFirstName = scanner.nextLine();
        System.out.print("Nouveau prenom : ");
        String newLastName = scanner.nextLine();
        System.out.print("Nouveau téléphone : ");
        String newPhone = scanner.nextLine();

        customer.setFirstname(newFirstName);
        customer.setLastname(newLastName);
        customer.setPhone(newPhone);

        bankService.updateCustomer(customer);
        System.out.println("Le client a bien été mis à jour");
    }

    private static void deleteCustomer() {
        System.out.print("ID de du client à supprimer : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        bankService.deleteCustomer(id);
        System.out.println("Client supprimé (et tous les comptes & transactions associés) avec succès !");
    }

    private static void makeDeposit() {
        System.out.println("Quel est l'Id du compte ?");
        int id = scanner.nextInt();
        System.out.print("Quel est le montant à déposer  : ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        Account account = bankService.getAccount(id);
        account.setBalance(account.getBalance()+amount);
        bankService.updateAccount(account);

        bankService.createTransaction(account, amount, "DEPOSIT");
    }

    private static void makeWithdrawal() {
        System.out.println("Quel est l'Id du compte ?");
        int id = scanner.nextInt();
        System.out.print("Quel est le montant à retirer  : ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        Account account = bankService.getAccount(id);
        account.setBalance(account.getBalance()-amount);
        bankService.updateAccount(account);

        bankService.createTransaction(account, amount, "WITHDRAWAL");
    }


    private static void getAccount() {
        System.out.println("Quel est l'Id du compte ?");
        int id = scanner.nextInt();

        Account account = bankService.getAccount(id);
        System.out.println(account);
    }
}
