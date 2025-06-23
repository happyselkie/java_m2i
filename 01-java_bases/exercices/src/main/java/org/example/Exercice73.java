package org.example;

import java.util.Scanner;

public class Exercice73 {
    public static void main(String[] args) {
         /*
        Jours dans le mois
         */

        // Créer une variable jour de type entier
        int mois;

        // Affecter une valeur à la variable mois
        Scanner scn = new Scanner(System.in);
        System.out.println("Saisir un numéro de mois :");
        mois = scn.nextInt();

        // Si le nombre est inférieur à 1 et supérieur à 12, afficher un message d'erreur
        if(mois < 1 || mois > 12) mois = 0;

        while (mois < 1){
            System.out.println("Erreur : veuillez saisir un numéro de mois entre 1 et 12 :");
            mois = scn.nextInt();
            if (mois > 12) mois = 0;
        }


        // Afficher le nombre de jours du mois
        switch (mois){
            case 1,3,5,7,8,10,12 -> System.out.println("31 jours");
            case 4,6,9,11 -> System.out.println("30 jours");
            case 2 -> System.out.println("28 ou 29 jours");
            default -> System.out.println("Saisie invalide");
        }

    }
}
