package org.example;

import java.util.Scanner;

public class Exercice71 {
    public static void main(String[] args) {
        /*
        Exercice : Voyelle ou consonne
         */
        // 1. Créer une variable caractere
        char character;
        String voyelles = "aeiouy";

        // 2. Affecter une valeur à la variable caractere
        Scanner scn = new Scanner(System.in);
        System.out.println("Saisir un caractère :");
        character = scn.nextLine().toLowerCase().charAt(0);

        if (character >= 'a' && character <= 'z'){
            if (voyelles.contains(Character.toString(character))) System.out.println("C'est une voyelle");
            else System.out.println("C'est une consonne");
        } else {
            System.out.println("Ce n'est pas une lettre.");
        }




/*
        boolean isVoyelle = false;

        if((character == 'a') || (character == 'e') || (character == 'i') || (character == '0' || (character == 'u') || (character == 'y'))){
            isVoyelle = true;
        }

        if(isVoyelle) System.out.println("C'est une voyelle");
        else System.out.println("C'est une consonne");*/
    }
}
