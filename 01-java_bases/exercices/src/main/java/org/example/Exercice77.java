package org.example;

import java.util.Scanner;

public class Exercice77 {
    public static void main(String[] args) {
        /*
        Exercice : Candidature
        Ecrire un programme qui permet de vérifier si un profil est valable pour une candidature
        Le profil contient trois critères :
        age : supérieur à 30 ans
        salaire demandé : maximum 40 000€
        années d'expériences : minimum 5 ans
         */

        int age, anneeExp;
        double salaire;

        // Afficher un message pour chaque condition non respectée
        Scanner scn = new Scanner(System.in);
        System.out.println("Saisir un age :");
        age = scn.nextInt();
        System.out.println("Saisir le salaire souhaité:");
        salaire = scn.nextDouble();
        System.out.println("Saisir le nombre d'années d'expériences:");
        anneeExp = scn.nextInt();

        if(age < 30 || salaire > 40000 || anneeExp < 5) {
            if (age < 30) System.out.println("Vous êtes trop jeune");
            if (salaire > 40000) System.out.println("Vous êtes trop cher");
            if (anneeExp < 5) System.out.println("Vous manquez d'expérience");
        }
        else System.out.println("Bienvenue chez nous !");

    }
}
