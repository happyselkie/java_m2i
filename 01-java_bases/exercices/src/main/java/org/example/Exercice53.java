package org.example;

import java.util.Scanner;

public class Exercice53 {
    public static void main(String[] args) {
        /*
        Exercice : Somme des carrés
        1. Écrire un programme avec les variables suivantes : a, b
        2. Afficher la somme des carrés de ces deux nombres
         */

        int a,b,square;
        Scanner scn = new Scanner(System.in);
        System.out.println("Saisir la valeur pour a");
        a = scn.nextInt();
        System.out.println("Saisir la valeur pour b");
        b = scn.nextInt();

        square = (a*a + b*b);

        System.out.println("La somme des carrés de a et de b est "+square);
    }
}
