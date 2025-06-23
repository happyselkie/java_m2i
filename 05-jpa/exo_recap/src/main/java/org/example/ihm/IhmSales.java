package org.example.ihm;

import org.example.entity.Customer;
import org.example.entity.Product;
import org.example.entity.Sale;
import org.example.entity.SaleLine;
import org.example.enums.SaleStatus;
import org.example.service.CustomerService;
import org.example.service.SaleService;
import org.example.util.EnumChecker;

import javax.persistence.EntityNotFoundException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class IhmSales extends Ihm{

    private static SaleService saleService = new SaleService();
    private static CustomerService customerService = new CustomerService();

    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("*********************** Gestion des ventes **************************");
            System.out.println("*   Que voulez-vous faire ?                              *");
            System.out.println("*   [1] Enregistrer une nouvelle vente                   *");
            System.out.println("*   [2] Voir les ventes en cours                         *");
            System.out.println("*   [3] Voir les ventes finalisées                       *");
            System.out.println("*   [4] Voir les ventes annulées                         *");
            System.out.println("*   [5] Voir le détail d'une vente                       *");
            System.out.println("*   [6] Changer le status d'une vente                    *");
            System.out.println("*   [0] Retour au menu principal                         *");
            System.out.println("*   Choix : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createSale();
                    break;
                case 2:
                    displayProcessed();
                    break;
                case 3:
                    displayFinished();
                    break;
                case 4:
                    displayCanceled();
                    break;
                case 5:
                    displaySale();
                    break;
                case 6:
                    changeStatus();
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

    public static void createSale() {
        System.out.println("Combien de produits voulez-vous ajouter à la vente ?");
        int nbrLine = scanner.nextInt();
        scanner.nextLine();

        List<SaleLine> saleLines = new ArrayList<>();

        for (int i = 0; i < nbrLine; i++) {
            boolean validRef = false;
            Product product = null;

            while (!validRef) {
                System.out.println("Saisir la ref du produit "+(i+1)+":");
                String ref = scanner.nextLine();
                try{
                   product =  productService.getByRef(ref);
                    validRef = true;
                } catch (EntityNotFoundException e){
                    System.out.println("Erreur : ce produit n'exite pas. Veuillez saisir une référence associée à un produit :");
                }
            }

            System.out.println("Saisir la quantité "+(i+1)+":");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            boolean validQuantity = false;

            while (!validQuantity) {
                if(quantity > product.getStock()){
                    System.out.println("Erreur : le produit n'a pas assez de stock. Stock disponible : "+product.getStock()+" Saisir une quantité valide pour le produit"+(i+1)+" (pour annuler ce produit taper \"0\"):");
                    quantity = scanner.nextInt();
                } else{
                    validQuantity = true;
                }
            }

            if (quantity  == 0){ continue; }

            product.setStock(product.getStock() - quantity);
            productService.update(product);

            SaleLine saleLine = SaleLine.builder().productQuantity(quantity).product(product).build();
            saleLines.add(saleLine);
        }

        Date saleDAte = dateChecker.dateToSqlDate(LocalDate.now().toString());

        System.out.println("Saisir l'id du client : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Customer customer = null;
        boolean validId = false;

        while (!validId) {
            try{
                customer = customerService.getById(id);
                validId = true;
            } catch (EntityNotFoundException e){
                System.out.println("Erreur : Ce client n'existe pas. Veuillez saisir une adresse email associée à un client");
            }
        }

        Sale sale =  saleService.createSale(saleDAte, SaleStatus.PROCESSED, customer, saleLines);
        for (SaleLine saleLine : saleLines) {
            saleService.createSaleLine(saleLine.getProductQuantity(), saleLine.getProduct(), sale);
        }

        System.out.println("La vente "+sale.getIdSale()+" a bien été créee avec le status \"en cours\". Le stock des produits a changé. Pour changer le status, veuillez saisir l'option \"Changer le status d'une vente\"");
    }

    public static void displayProcessed() {
        saleService.getBySatus(SaleStatus.PROCESSED).forEach(System.out::println);
    }

    public static void displayFinished() {
        saleService.getBySatus(SaleStatus.FINISHED).forEach(System.out::println);
    }

    public static void displayCanceled() {
        saleService.getBySatus(SaleStatus.CANCELLED).forEach(System.out::println);
    }

    public static void displaySale() {
        System.out.println("Saisir l'id de la vente:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Sale sale = saleService.getById(id);

        while (sale == null){
            System.out.println("Erreur, la vente n'existe pas. Veuillez saisir l'id de la vente :");
            id = scanner.nextInt();
            scanner.nextLine();
            sale = saleService.getById(id);
        }

        System.out.println(sale);
    }

    public static void changeStatus() {
        System.out.println("Saisir l'id de la vente:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Sale sale = saleService.getById(id);

        while (sale == null){
            System.out.println("Erreur, la vente n'existe pas. Veuillez saisir l'id de la vente :");
            id = scanner.nextInt();
            scanner.nextLine();
            sale = saleService.getById(id);
        }

        boolean validStatus = false;
        SaleStatus saleStatus = null;
        while (!validStatus) {
            System.out.println("Saisir le nouveau statut (processed, finished or cancelled):");
            try{
                saleStatus = EnumChecker.getSalesStatus(scanner.nextLine());
                validStatus = true;
            } catch (InputMismatchException e){
                System.out.println("Erreur, veuillez saisir un statut correct.");
            }
        }


        saleService.changeStatus(sale, saleStatus);
        System.out.println("Le status de la vente :"+sale.getIdSale()+ " a bien été changé en "+saleStatus.toString());
    }




}
