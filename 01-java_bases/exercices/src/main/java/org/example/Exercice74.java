package org.example;

import java.util.Scanner;

public class Exercice74 {
    public static void main(String[] args) {
        /*
        Exercice : Année bissextile
         */

        // Créer une variable jour de type entier
        int annee;

        // Affecter une valeur à la variable annee
        Scanner scn = new Scanner(System.in);
        System.out.println("Saisir une année :");
        annee = scn.nextInt();

        // Une année est bissextile si elle est divisible par 4 mais non divisible par 100
        // L'année est également bissextile si elle est divisible par 400

        if(annee%400 == 0) System.out.println(annee + " est une année bisextile");
        else{
            if(annee%4 == 0 && annee%100 != 0) System.out.println(annee + " est une année bisextile");
            else System.out.println(annee + " n'est pas une année bisextile");
        }
    }
}
