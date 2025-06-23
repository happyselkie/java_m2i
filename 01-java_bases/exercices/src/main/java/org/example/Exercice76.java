package org.example;

import java.util.Scanner;

public class Exercice76 {
    public static void main(String[] args) {
        /*
        Exercice : Etat de l'eau
         */

        // Définir une variable température
        int temperature;

        // Affecter une valeur à la variable temperature
        Scanner scn = new Scanner(System.in);
        System.out.println("Saisir une température :");
        temperature = scn.nextInt();

        // Selon la température, affiche l'état de l'eau :
        if(temperature < 0) System.out.println("SOLIDE");
        else{
            if(temperature > 100) System.out.println("GAZEUX");
            else System.out.println("LIQUIDE");
        }
    }
}
