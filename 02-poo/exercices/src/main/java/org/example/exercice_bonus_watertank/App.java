package org.example.exercice_bonus_watertank;

import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int option = 1;

        WaterTank water1 = new WaterTank(10, 20, 10, "citerne1");
        WaterTank water2 = new WaterTank(5, 10, 10, "citerne2");
        Map<String, WaterTank> allWatertanks =  WaterTank.getWaterTankList();


        System.out.println(
                "*`*`*`*`*`*`*`*` WaterTank *`*`*`*`*`*`*`*` \n"+
                "------------------------------------------- \n" +
                "Il y a actuellement " + WaterTank.getWatertankQuantity() +" citernes \n" +
                "------------------------------------------- \n"
        );

        while (option != 0){
            System.out.println(
                            "========= Que voulez-vous faire ? ========= \n" +
                            "  [1] Voir le poids total des citernes \n" +
                            "  [2] Voir les quantités d'eau \n" +
                            "  [3] Ajouter de l'eau dans une citerne \n" +
                            "  [4] Vider de l'eau dans une citerne \n" +
                            "  [0] Quitter"
            );

            option = scn.nextInt();
            scn.nextLine();
            WaterTank choice;
            int rest;
            int input;

            switch (option){
                case 1 :
                    allWatertanks.forEach( (k, v) -> {
                        System.out.println("Poids total de "+v.getName() + " : " + v.getPoidsTotal());
                    } );
                    System.out.println("------------------------------------------- \n");
                    break;
                case 2 :
                    allWatertanks.forEach( (k, v) -> {
                        System.out.println("Quantité d'eau dans "+v.getName() + " : " + v.getFillLevel() + " / " + v.getMaxCapacity());
                    });
                    System.out.println("Quantité d'eau dans toutes les citernes : "+ WaterTank.getTotalFillLevel());
                    System.out.println("------------------------------------------- \n");
                    break;
                case 3 :
                    System.out.println("Dans quelle citerne ? (saisir le nom)");
                    allWatertanks.forEach( (k, v) -> {
                        System.out.println(v.getName());
                    });
                    choice = allWatertanks.get(scn.nextLine());
                    if (choice == null) {
                        System.out.println("Erreur, pas de citerne à ce nom");
                        break;
                    }
                    System.out.println("Quelle quantité ?");
                    input = scn.nextInt();
                    rest = choice.fill(input);

                    if(rest != -1){
                        System.out.println("Quantité d'eau dans "+choice.getName()+ " après ajout de "+input+" litres: "+choice.getFillLevel()+"/"+choice.getMaxCapacity());
                        if(rest > 0) System.out.println("Excès d'eau récupéré : " + rest);
                    }

                    System.out.println("------------------------------------------- \n");
                    break;
                case 4 :
                    System.out.println("Dans quelle citerne ? (saisir le nom)");
                    allWatertanks.forEach( (k, v) -> {
                        System.out.println(v.getName());
                    });
                    choice = allWatertanks.get(scn.nextLine());
                    if (choice == null) {
                        System.out.println("Erreur, pas de citerne à ce nom");
                        break;
                    }
                    System.out.println("Quelle quantité ?");
                    rest = choice.empty(scn.nextInt());
                    if(rest != -1){
                        System.out.println("Quantité d'eau dans "+choice.getName()+ " après tentative de retrait de "+scn.nextInt()+" litres: "+choice.getFillLevel()+"/"+choice.getMaxCapacity());
                        if(rest > 0) System.out.println("Quantité d'eau récupérée : " + rest);
                    }
                    System.out.println("------------------------------------------- \n");
                    break;
                case 0:
                    break;
                default: break;
            }
        }

        System.out.println("Quantité d'eau dans la citerne 1 : " + water1.getFillLevel());
        System.out.println("Quantité d'eau dans la citerne 2 : " + water2.getFillLevel());
        System.out.println("Quantité d'eau dans toutes les citernes : " + WaterTank.getTotalFillLevel());
        System.out.println("----------------------------------------------------------");

    }
}
