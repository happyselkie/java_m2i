package org.example;

import java.util.Scanner;

public class Exercice80 {
    public static void main(String[] args) {
        /*
        Exercice : Tables de multiplications
        Créer un programme permettant d'afficher les tables demultiplications de 1 à 10
         */
        for (int i = 1; i <= 10; i++){
            System.out.println("Table de multiplication de "+i);
            for (int j = 1; j <= 10; j++) System.out.println(j + " x " + i +" = " +(j*i));
        }
    }
}
