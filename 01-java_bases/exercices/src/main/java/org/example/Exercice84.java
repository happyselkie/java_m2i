package org.example;

import java.util.Scanner;

public class Exercice84 {
    public static void main(String[] args) {
        /*
        Exercice : Nombres premiers
        Un nombre premier est un nombre divisible par 1 et par soit-même uniquement
        1 n'est pas un nombre premier
        Écrire un programme qui permet de savoir si un nombre est premier
         */

        int nbr = 0;
        boolean notPremier = false;

        Scanner scn = new Scanner(System.in);
        System.out.println("Saisir un nombre ( > 1) ");
        nbr = scn.nextInt();

        while (nbr < 2){
            System.out.println("Erreur, le nombre doit être supérieur à 1. Saisir un nombre ( > 1)");
            nbr = scn.nextInt();
        }

        for (int i = 2; i < nbr; i++){
            if(nbr%i == 0) notPremier = true; break;
        }

        if(notPremier) System.out.println(nbr + " n'est pas un nombre premier");
        else System.out.println(nbr + " est un nombre premier");
    }
}
