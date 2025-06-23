package org.example;

import java.util.Scanner;

public class Exercice82 {
    public static void main(String[] args) {
        /*
        Exercice : Sommes consécutives
         */

        //Déclarer une variable nombre
        int nbr;

        Scanner scn = new Scanner(System.in);
        System.out.println("Veuillez entrer un nombre : ");
        nbr = scn.nextInt();

        //Premiere boucle qui gere le début de la liste (on peut faire cpt < nbr / 2 +1 parce qu'on ira jamais plus loin que la moitié
        for (int cpt = 1; cpt < nbr; cpt++ ){
            String result = nbr + " = " + cpt;
            int som = cpt;
            // seconde boucle qui permet de calculer la reste de la suite :
            for (int suite = cpt + 1; cpt <  nbr; suite++){
                result += " + " + suite;
                som += suite;

                // Si on dépasse, on sort de la boucle
                if(som > nbr) break;
                // si la somme est égales au nombre, on affiche le résultat et on sort de la boucle
                else if (som == nbr) System.out.println(result);
            }
        }
    }
}
