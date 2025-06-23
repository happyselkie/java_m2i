package org.example;

import java.util.Scanner;

public class Exercice86 {
    public static void main(String[] args) {
        /*
        Exercice : Factorielle
        1.La factorielle d'un nombre positif est le quotient cumulatif des nombres allant de 1 à ce nombre
        2.Exemple : la factorielle de 3 est 1 x 2 x 3 = 6
        3.Réaliser un programme qui affiche la factorielle d'un nombre
         */

        int nbr = 0;
        int fac = 1;

        Scanner scn = new Scanner(System.in);
        System.out.println("Saisir un nombre :");
        nbr = scn.nextInt();
        String message = "";

        for (int i = 1; i <= nbr; i++){
            fac = fac * i;
            if(i == nbr) System.out.print(i + " = " + fac);
            else System.out.print(i + " x ");
        }
        System.out.println();
        System.out.println("La factorielle de " + nbr + " est " + fac);
    }
}
