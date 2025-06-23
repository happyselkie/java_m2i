package org.example.exercice_bonus_pendu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu {
    public static void main(String[] args) {
        String motMystere =  "Coucou";
        motMystere = motMystere.toLowerCase();
        char[] motSplit = motMystere.toCharArray();

        List<Character> motAtrouve = new ArrayList<>();
        List<Character> masque = new ArrayList<>();

        Scanner scn = new Scanner(System.in);

        for(char charactere : motSplit) {
            motAtrouve.add(Character.valueOf(charactere));
            masque.add('*');
        }

        Pendu lePendu = new Pendu(motAtrouve, masque);

        int nbEssai = lePendu.getEssais();

        for (int i = 0; i < motAtrouve.size(); i++) lePendu.genererMasque(i, '*');

        System.out.println("* * * * * * * * * Le Pendu * * * * * * * *");
        System.out.println("" +
                "               ===========" + "\n" +
                "               |         |" + "\n" +
                "               O         |" + "\n" +
                "              /|\\        |"+ "\n" +
                "              / \\        |"+ "\n"

        );

        System.out.println("========= Paramètres de partie ========");
        System.out.println("Voulez-vous un nombe d'essais spécifique (10 par défaut) ? y/n : ");
        char choix = scn.next().toLowerCase().charAt(0);

        while (choix != 'y' && choix != 'n'){
            System.out.println("Erreur veuillez choisir entre y ou n. Voulez-vous un nombe d'essais spécifique (10 par défaut) ? y/n : ");
            choix = scn.next().toLowerCase().charAt(0);
        }

        if (choix == 'y'){
            System.out.printf("Combien d'essais voulez-vous ?");
            nbEssai = scn.nextInt();
            while (nbEssai < 0) {
                System.out.printf("Erreur, veuillez entrer une valeur positive. Combien d'essais voulez-vous ?");
                nbEssai = scn.nextInt();
            }
        }

        System.out.println("Jeu du pendu généré ! Nombre d'essais : "+nbEssai);

        char guess;

        while (nbEssai > 0){
            System.out.println("Le mot à trouver : "+lePendu.getStringMasque());
            String guessWord = scn.next().toLowerCase();
            guess = guessWord.charAt(0);
            lePendu.testChar(guess);
            nbEssai--;
            if(lePendu.testWin()) break;
            else System.out.println("Nombre d'essais restants : "+nbEssai);
        }

        if(lePendu.testWin()) System.out.println("Bien joué ! vous avez trouvé en "+nbEssai+" tentatives !");
        else System.out.printf("Perdu ! Essayez encore.");
    }
}
