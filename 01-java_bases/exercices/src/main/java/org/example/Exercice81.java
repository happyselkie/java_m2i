package org.example;

public class Exercice81 {
    public static void main(String[] args) {
        double pop = 96809;
        double taux = 0.89f / 100.0f;
        int annees = 0;

        for (int an = 1; pop <= 120000; an++){
            pop = pop + (pop*taux);
            annees = an;
            System.out.println("Année "+an+": "+ Math.floor(pop));
        }

        System.out.println("Il faudra "+annees+" ans pour atteindre une population d'environ 120 000 habitants");
    }
}
