package org.example;

import java.util.Scanner;

public class Exercice54 {
    public static void main(String[] args) {
        /*
        Exercice : majeur ou mineur
1. Créer une variable age et lui affecter une valeur
2. Vérifier si la personne est mineure ou majeure à l'aide desopérateurs logiques
3.Afficher le résultat
4. /!\ Ne pas utiliser de structure conditionnelle
         */

        int age;
        Scanner scn = new Scanner(System.in);

        System.out.println("Saisir un age");
        age = scn.nextInt();
        System.out.println(age>=18);
    }
}
