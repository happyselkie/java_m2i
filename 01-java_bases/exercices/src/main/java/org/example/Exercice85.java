package org.example;

import java.util.Scanner;

public class Exercice85 {
    public static void main(String[] args) {
        /*
        Exercice : Nombre mystère
        1.Générer un nombre aléatoire entre 1 et 100
        2.Faire saisir un nombre à l'utilisateur
        3.Si le chiffre saisi est plus grand, écrire : Le nombre est plus petit
        4.Si le chiffre saisi est plus petit, écrire : Le nombre est plus grand
        5.Si le chiffre saisi est égal au chiffre aléatoire, écrire : Vous avez gagné en Xtentatives
         */

        int rand = (int)(Math.random() * 100) + 1;
        int cpt = 1;
        int nbr = 0;

        Scanner scn = new Scanner(System.in);

        while(true){
            System.out.println("Saisir un nombre");
            nbr = scn.nextInt();
            if(nbr == rand) break;
            if(nbr < rand) System.out.println("Le nombre est plus grand");
            else System.out.println("Le nombre est plus petit");
            cpt++;
        }

        System.out.println("Bravo, vous avez gagné en " + cpt + " tentatives");
    }
}
