package org.example;

import java.util.Scanner;

public class Exercice68 {
    public static void main(String[] args) {
        /*
        Exercice : majeur ou mineur
         */

        // Créer une variable age
        int age;
        Scanner scn = new Scanner(System.in);

        System.out.println("Saisir un age");
        // Affecter une valeur à la variable age
        age = scn.nextInt();

        // Créer une condition qui permet d'afficher si la personne estmajeure ou mineure

        String result = (age >= 18) ? "Vous êtes majeur, vous pouvez entrer dans le club" : "YOU SHALL NOT PASS.";

        System.out.println(result);
    }
}
