package org.example;

import java.util.Scanner;

public class Exercice51 {
    public static void main(String[] args) {
        /*
        Exercice : Prénom nom
         1.Créer une variable nom et une variable prenom
         2.Afficher la phrase suivante "Bonjour {prenom} {NOM}."
         3.Remplacer les valeurs entre chevrons par les variables crééesprécédemment
        * */

        String nom, prenom;

        Scanner scn = new Scanner(System.in);
        System.out.println("Quel est votre nom ?");
        nom = scn.nextLine();

        System.out.println("Quel est votre prénom ?");
        prenom = scn.nextLine();

        System.out.println("Bonjour "+prenom +" "+ nom);
    }
}
