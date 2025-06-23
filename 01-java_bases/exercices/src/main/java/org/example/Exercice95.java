package org.example;

import java.util.Arrays;

public class Exercice95 {
    public static void main(String[] args) {
        /*
        Exercice : Tableau positif
        1.Déclarer deux tableaux de 10 éléments
        2. Le premier tableau contiendra des nombres négatifs et positifs
        3.Ajouter tous les éléments positifs du premier tableau dans lesecond tableau
         */
        int[] tableauSource = {-5, 3, 24, -12, -10, 5, 100, -2, -71, 0};
        int[] tableauDestination = new int [tableauSource.length];

        /*for (int i = 0; i < tableauSource.length; i++){
            if(tableauSource[i] > 0) tableauDestination[i] = tableauSource[i];
        }*/

        int cpt = 0;
        for (int valeur : tableauSource){
            if(valeur > 0) {
                tableauDestination[cpt] = valeur;
                cpt++;
            }
        }

        System.out.println(Arrays.toString(tableauDestination));

    }
}
