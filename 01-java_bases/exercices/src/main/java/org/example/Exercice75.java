package org.example;

import java.util.Scanner;

public class Exercice75 {
    public static void main(String[] args) {
        /*
        Exercice : Lettre, nombre ou caractère spécial
         */

        // Créer une variable caractere
        char caractere;

        // Affecter une valeur à la variable caractere
        Scanner scn = new Scanner(System.in);
        System.out.println("Saisir un caractère :");
        caractere = scn.nextLine().charAt(0);

        // Afficher un message en fonction du type du caractère (lettre,nombre, ou caractère spécial)
        if(Character.isLetterOrDigit(caractere)){
            if(Character.isLetter(caractere)) System.out.println(caractere + " est une lettre de l'alphabet");
            else System.out.println(caractere + " est un chiffre");
        } else {
            System.out.println(caractere + " est un caractère spécial");
        }


        /*int asciiChar = caractere;
        if((asciiChar >= 33 && asciiChar < 48) || (asciiChar > 57 && asciiChar < 58) || (asciiChar > 90 && asciiChar < 97) || (asciiChar > 122 && asciiChar < 127)) System.out.println(caractere + " est un caractère spécial");
        else if (asciiChar > 47 && asciiChar < 58) System.out.println(caractere + " est un chiffre");
        else if ((asciiChar > 64 && asciiChar < 91) || (asciiChar > 96 && asciiChar < 123)) System.out.println(caractere + " est une lettre de l'alphabet");
        else System.out.println(caractere + " n'est pas affichable parce que c'est une commande de saisie");*/
    }
}
