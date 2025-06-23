package org.example;

import java.util.Scanner;

public class Exercice70 {
    public static void main(String[] args) {
        /*
        Exercice : Maximum de 3 nombres
         */

        // Créer 3 variables : nombre1, nombre2, nombre3
        int nombre1,nombre2,nombre3;

        // Affecter des valeurs aux variables
        Scanner scn = new Scanner(System.in);

        System.out.println("Saisir le nombre 1");
        nombre1 = scn.nextInt();
        System.out.println("Saisir le nombre 2");
        nombre2 = scn.nextInt();
        System.out.println("Saisir le nombre 3");
        nombre3 = scn.nextInt();

        // Créer des structures conditionnelles permettant d'afficher lemaximum parmis les 3 nombres créés précédemment
        int max;
        if(nombre1 > nombre2){
            if(nombre1 > nombre3) max = nombre1;
            else max = nombre3;
        } else {
            if(nombre2 > nombre3) max = nombre2;
            else max = nombre3;
        }

        System.out.println("Le nombres maximum est : "+max);
    }
}
