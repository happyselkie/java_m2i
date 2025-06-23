package org.example.exercice4;

public class WaterTank {
    private double poidsAVide;
    private double capaciteMax;
    private double niveauRemplissage;

    private static double volumeCiterne;

    public WaterTank(double poidsAVide, double capaciteMax, double niveauRemplissage) {
        this.poidsAVide = poidsAVide;
        this.capaciteMax = capaciteMax;
        this.niveauRemplissage = niveauRemplissage;
    }

    public double getPoidsAVide() {
        return poidsAVide;
    }

    public void setPoidsAVide(double poidsAVide) {
        this.poidsAVide = poidsAVide;
    }

    public double getCapaciteMax() {
        return capaciteMax;
    }

    public void setCapaciteMax(double capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    public double getNiveauRemplissage() {
        return niveauRemplissage;
    }

    public void setNiveauRemplissage(double niveauRemplissage) {
        if(niveauRemplissage > capaciteMax) System.out.println("Le niveau de remplissage ne peut pas dépasser la capacité maximale");
        else if (niveauRemplissage < poidsAVide) System.out.println("Le niveau de remplissage ne peut pas être inférieur au poids à vide");
        else this.niveauRemplissage = niveauRemplissage;
    }

    public static double getVolumeCiterne() {
        return volumeCiterne;
    }

    public void remplir(double quantite){
        if(volumeCiterne + quantite > capaciteMax) System.out.println("La quantité totale dépassera la capacité maximale");
        else volumeCiterne++;
    }

    public void vider(double quantite){
        if(volumeCiterne - quantite < poidsAVide) System.out.println("On ne peut pas vider plus");
        else volumeCiterne--;
    }


    @Override
    public String toString() {
        return "WaterTank{" +
                "poidsAVide=" + poidsAVide +
                ", capaciteMax=" + capaciteMax +
                ", niveauRemplissage=" + niveauRemplissage +
                '}';
    }
}
