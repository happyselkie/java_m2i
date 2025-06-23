package org.example;

import java.util.Scanner;

public class Exercice56 {
    public static void main(String[] args) {
        /*
        Exercice : Mise en forme de chaînes

2. Effectuer les traitements suivants :
1. Afficher la chaîne en minuscule
2. Afficher la chaîne en majuscule
3.Bonus
1.Convertir la chaîne en tableau puis afficher les caractères séparer d'une virgule
2.Afficher la première lettre de chaque mot en majuscule
         */

        String chaine;
        Scanner scn = new Scanner(System.in);

        //1. Saisir une chaine et la stocker dans une variable
        System.out.println("Saisir une chaîne de caractères :");
        chaine = scn.nextLine();

        //Afficher la chaîne en minuscule
        System.out.println("Chaine en minuscule : " + chaine.toLowerCase());

        //Afficher la chaîne en majuscule
        System.out.println("Chaine en minuscule : " + chaine.toUpperCase());

        // Convertir la chaîne en tableau puis afficher les caractères séparer d'une virgule

        String noWhiteSpaces = chaine.replaceAll("\\s+",""); //Enlève les espaces pour n'avoir que les lettres
        char[] characters = noWhiteSpaces.toCharArray();
        String allCharacters = "";

        for (int i = 0; i < characters.length; i++){
            if(i==0) allCharacters += characters[i];
            else allCharacters += ", "+characters[i];
        }

        System.out.println(allCharacters);

        // Afficher la première lettre de chaque mot en majuscule
        String[] splitChaine = chaine.split("\\s+");
        String maj = "";
        for(String word : splitChaine){
           maj += word.substring(0,1).toUpperCase()+word.substring(1)+" ";
        }
        System.out.println(maj);
    }
}
