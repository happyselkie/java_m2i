package org.example;

public class Exercice97 {
    public static void main(String[] args) {
        /*
        Exercice : Tableaux égaux
        1.Ecrire un programme qui permet de vérifier si 2 tableaux sont égaux
        2.Vérifier la taille des tableaux et l'ordre des valeurs
         */

        int[] tableau1 = {1, 4, 2, 3};
        int[] tableau2 = {1, 4, 2, 3};
        boolean isEqual = true;

        if(tableau1.length == tableau2.length){
            // Mieux: utiliser Arrays.equals mais pour l'exercice on va utiliser une boucle

            for (int i = 0; i < tableau1.length; i++){
                if (tableau1[i] != tableau2[i]) {
                    isEqual = false;
                    break;
                }
            }
        } else {
            isEqual = false;
        }

        if (isEqual) System.out.println("Les tableaux sont égaux");
        else System.out.println("Les tableaux ne sont pas égaux");




    }
}
