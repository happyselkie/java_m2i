package org.example;

import java.util.Arrays;

public class Exercice94 {
    public static void main(String[] args) {
        /*
        Exercice : 100 éléments
         */
        
        //1. Déclarer un tableau de 100 éléments et l'initialiser
        
        int[] centElem = new int[100];
        for (int i = 0; i <= 99; i++) {
            centElem[i] = i;
        }

        String result = "";
        
        // 2.Afficher les éléments par dizaine séparés d'une virgule
        for (int nbr : centElem){
            if(nbr == 0) result += nbr + ", ";
            else{
                if(nbr%10 == 0) result += "\n" + nbr + ", ";
                else result += nbr + ", ";
            }
        }

        System.out.println(result);
        
    }
}
