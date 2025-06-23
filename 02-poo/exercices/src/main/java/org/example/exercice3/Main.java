package org.example.exercice3;

public class Main {
    public static void main(String[] args) {

        Joueur joueur1 = new Joueur("WarriorDu59", 1, 0);

        String nomJoueur1 = joueur1.getNom();
        for(int i = 1; i <= 20; i++){
            System.out.println("Le joueur "+ nomJoueur1 + " effectue la quête n°" + i);
            joueur1.effectuerUneQuete();
        }

        joueur1.setNom("LeGigaBossDuJava");
    }
}
