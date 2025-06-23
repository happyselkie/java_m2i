package org.example;

import java.util.Scanner;

public class Exercice83 {
    public static void main(String[] args) {
        /*
        Exercice : Notes
         */

        // Créer une variable stockant le nombre de notes à saisir
        int nbrNotes;
        int max = 0;
        int min = 0;
        int moyenne = 0;
        int nbr = 0;

        Scanner scn = new Scanner(System.in);
        System.out.println("Combien de notes souhaitez-vous saisir ? ");
        nbrNotes = scn.nextInt();

        for (int i = 1; i <= nbrNotes; i++){
            System.out.println("Veuillez saisir la note "+ i);
            nbr = scn.nextInt();

            // /!\ la note doit être comprise entre 0 et 20
            if(nbr < 1 || nbr > 20){
                nbr = 0;
                while(nbr<1){
                    System.out.println("Erreur, la note saisie doit être comprise entre 1 et 20. Veuillez saisir la note " + i);
                    nbr = scn.nextInt();
                    if(nbr > 20) nbr = 0;
                }
            }
            moyenne = moyenne + nbr;
            if(i == 1) {
                max = nbr;
                min = nbr;
            }
            else {
                if(max < nbr) max = nbr;
                if(min > nbr) min = nbr;
            }

            moyenne = moyenne/nbrNotes;
        }

        System.out.println("La note la plus élèvée est: " + max);
        System.out.println("La note la plus basse est: " + min);
        System.out.println("La moyenne est: " + moyenne);

    }
}
