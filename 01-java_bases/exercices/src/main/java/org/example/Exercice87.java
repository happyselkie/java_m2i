package org.example;

import java.util.Scanner;

public class Exercice87 {
    public static void main(String[] args) {
        /*
        Exercice : Nombre fort
        1.Un nombre fort est un nombre dont la somme de la factorielle des chiffres qui le constitue est égale à ce nombre
        2.Par exemple : 145 = 1! + 4! + 5! soit 145 = 1 + 24 + 120
        3.Écrire un programme qui permet de savoir si un nombre est fort
         */

        int nbrInitial, nbr, chiffre, fac;
        int somFac = 0;

        Scanner scn = new Scanner(System.in);
        System.out.println("Saisir un nombre :");
        nbrInitial = scn.nextInt();

        nbr = nbrInitial;

        while (nbr > 0) {
            fac = 1;
            chiffre = nbr%10;
            for (int i = 1; i <= chiffre; i++){
                fac = fac * i;
            }
            somFac += fac;
            nbr = nbr / 10;
        }

        if(somFac == nbrInitial) System.out.printf("Il est fort ce nombre ! ");
        else System.out.printf("Ce n'est pas un nombre fort");
    }
}
