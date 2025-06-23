package org.example;

import java.util.Scanner;

public class Exercice79 {
    public static void main(String[] args) {
        /*
        Créer un programme qui permet d'afficher un nombre de chapitres et de sous-parties
        Le programme demandera le nombre de chapitres ainsi que le nombre de sous-parties àafficher
         */

        int chapitre, ssChapitre;
        Scanner scn = new Scanner(System.in);
        System.out.println("Saisir un nombre de chapitres :");
        chapitre = scn.nextInt();
        System.out.println("Saisir un nombre de sous-partie :");
        ssChapitre = scn.nextInt();

        for(int i = 0; i < chapitre; i++){
            System.out.println("Chapitre " + (i+1));
            for (int j = 0; j < ssChapitre; j++) System.out.println("   Sous-partie "+ (i+1) + "." + (j+1));
        }
    }
}
