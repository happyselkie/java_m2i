package org.example.exercice5;

public class Plantes {
    private String nom;
    private int hauteurFeuilles;
    private String couleurFeuilles;

    public Plantes(String nom, int hauteurFeuilles, String couleurFeuilles) {
        this.nom = nom;
        this.hauteurFeuilles = hauteurFeuilles;
        this.couleurFeuilles = couleurFeuilles;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getHauteurFeuilles() {
        return hauteurFeuilles;
    }

    public void setHauteurFeuilles(int hauteurFeuilles) {
        this.hauteurFeuilles = hauteurFeuilles;
    }

    public String getCouleurFeuilles() {
        return couleurFeuilles;
    }

    public void setCouleurFeuilles(String couleurFeuilles) {
        this.couleurFeuilles = couleurFeuilles;
    }

    @Override
    public String toString() {
        return "Ceci est une plante. Son nom est: " +this.nom+ "; ses feuilles ont une taille de "+this.hauteurFeuilles+" et sont de couleur "+this.couleurFeuilles;
    }
}
