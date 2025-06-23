package org.example.exercice3;

public class Joueur {
    private String nom;
    private int niveau;
    private int experience;

    public Joueur(String nom, int niveau, int experience) {
        this.nom = nom;
        this.niveau = niveau;
        this.experience = experience;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        System.out.println(this.nom + " change de pseudo: " +nom);
        this.nom = nom;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void effectuerUneQuete(){
        this.experience += 10;
        if(this.experience >= 100) this.levelUp();
    }

    private void levelUp (){
        this.niveau++;
        this.experience = 0;
        System.out.println("Le joueur  "+this.nom+" passe au niveau: " +this.niveau);
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "nom='" + nom + '\'' +
                ", niveau=" + niveau +
                ", experience=" + experience +
                '}';
    }
}
