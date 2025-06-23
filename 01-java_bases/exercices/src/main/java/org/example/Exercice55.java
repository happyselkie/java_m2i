package org.example;

import java.util.Scanner;

public class Exercice55 {
    public static void main(String[] args) {
        /*
        Exercice : volume d'un cercle
        1. Créer un programme qui permet de calculer le volume d'un cône
        2.La formule est la suivante : 1/3 × π × r² × h
         */

        int r, h;

        Scanner scn = new Scanner(System.in);

        System.out.println("Saisir un rayon");
        r = scn.nextInt();
        System.out.println("Saisir une hauteur");
        h = scn.nextInt();

        float tier = 1.0f / 3.0f;

        double volume = tier * Math.PI * Math.pow(r, 2) * h;

       // System.out.println("Le volume du cône est "+Math.floor(volume)+" cm³");
        System.out.printf("Le volume du cône est %.2f cm³", volume);
    }
}
