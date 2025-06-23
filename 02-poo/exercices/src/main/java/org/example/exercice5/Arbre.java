package org.example.exercice5;

public class Arbre extends Plantes{

    public Arbre(String nom, int hauteurFeuilles, String couleurFeuilles) {
        super(nom, hauteurFeuilles, couleurFeuilles);
    }


    @Override
    public String toString() {
        return "Ceci est un arbre. Son nom est: " +super.getNom()+ "; ses feuilles ont une taille de "+super.getHauteurFeuilles()+" et sont de couleur "+super.getCouleurFeuilles();
    }
}
