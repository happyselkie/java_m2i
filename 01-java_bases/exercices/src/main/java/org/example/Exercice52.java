package org.example;

import java.util.Scanner;

public class Exercice52 {
    public static void main(String[] args) {
        /*
        Exercice : Permuter deux variables
        1. Écrire un programme qui permet de permuter les valeurs entre deux variables
         */

        int a,b,c;
        Scanner scn = new Scanner(System.in);
        System.out.println("Saisir la valeur pour a");
        a = scn.nextInt();
        System.out.println("Saisir la valeur pour b");
        b = scn.nextInt();

        c = a;
        a = b;
        b = c;

        System.out.println("a = "+a+" et b = "+b);
    }
}
