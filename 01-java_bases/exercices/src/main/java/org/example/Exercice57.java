package org.example;

import java.util.Scanner;

public class Exercice57 {
    public static void main(String[] args) {
        /*
        Périmètre et aire d'un carré
         */

        //Saisir la longueur du côté du carré et la stocker dans une variable
        int l, perimetre, aire;
        Scanner scn = new Scanner(System.in);
        System.out.println("Saisir la longueur d'un côté");
        l = scn.nextInt();

        // Calculer l'aire et le périmètre du carré
        perimetre = 4*l;
        aire = l*l;

        System.out.println("Le périmètre du carré est de : "+perimetre+"cm");
        System.out.println("L'aire du carré est de : "+aire+"cm carré");
    }
}
