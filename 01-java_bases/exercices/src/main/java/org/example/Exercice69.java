package org.example;

import java.util.Scanner;

public class Exercice69 {
    public static void main(String[] args) {
        /*
        Exercice : Pair ou impair
         */

        // 1.Créer une variable nombre de type entier
        int nbr;
        Scanner scn = new Scanner(System.in);

        System.out.println("Saisir un nombre");
        // 2. Affecter une valeur à la variable nombre
        nbr = scn.nextInt();

        // 3. Créer une condition qui permet d'afficher si le nombre est pair ou impair
        String result = ((nbr % 2) == 0) ? "Le nombre saisi est pair" : "Le nombre saisir est impair";

        System.out.println(result);
    }
}
