package org.example.exerciceList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Annuaire{

    private static List<Company> companyList = new ArrayList<>();

    public static void addCompany(String name, int siret, String address, String website){
        Company company = new Company(name, siret, address, website);
        companyList.add(company);
    }

    public static void seeCompaniesNames(){
        for (Company companyName : companyList) System.out.println(companyName.getName());
    }

    public static void seeCompaniesDetails(){
        for (Company company : companyList) System.out.println(company+"\n");
    }

    public static void launchAnnuaire(){
        int option = 0;
        Scanner scn = new Scanner(System.in);

        while (option != 4){
            System.out.println("======  Bienvenue sur l'annuaire d'entreprise : =====");
            System.out.println("Il y a actuellement "+companyList.size()+ " entreprise(s) dans l'annuaire");
            System.out.println("1) Ajouter une entreprise");
            System.out.println("2) Voir toutes les entreprises (leurs noms)");
            System.out.println("3) Voir les details d'une entreprise");
            System.out.println("4) Quitter");
            option = scn.nextInt();
            scn.nextLine();

            switch (option){
                case 1:
                    System.out.println("Quel est le nom de l'entreprise ?");
                    String name = scn.nextLine();
                    System.out.println("Quel est son siret ?");
                    int siret = scn.nextInt();
                    scn.nextLine();
                    System.out.println("Quelle est son adresse ?");
                    String address = scn.nextLine();
                    System.out.println("Quel est son site web ?");
                    String website = scn.nextLine();

                    Annuaire.addCompany(name, siret, address, website);
                    System.out.println("L'entreprise "+ name + " a bien été créée");
                    break;
                case 2 :
                    Annuaire.seeCompaniesNames();
                    break;
                case 3:
                    Annuaire.seeCompaniesDetails();
                    break;
                default:break;
            }
        }
    }

}
