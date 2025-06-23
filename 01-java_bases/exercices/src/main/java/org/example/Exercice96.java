package org.example;

public class Exercice96 {
    public static void main(String[] args) {
        /*
        Exercice : Valeur maximale
        1.Ecrire un programme qui permet de trouver la valeur maximale dans un tableau
         */

        int[] tableau = {23, 150, 12, 28, 59, 2};
        int max = 0;
        int indMax = 0;

        for (int i = 0; i < tableau.length;i++){
            if(i == 0) max = tableau[i];
            else if (tableau[i] > max) {
                max = tableau[i];
                indMax=i;
            }
        }

        System.out.println("La valeur maximale est "+max+" à l'indice " + indMax);
    }
}