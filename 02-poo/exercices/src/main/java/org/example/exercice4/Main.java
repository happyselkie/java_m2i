package org.example.exercice4;

public class Main {
    public static void main(String[] args) {
        WaterTank waterTank1 = new WaterTank(0.0,75.0,10.0);
        WaterTank waterTank2 = new WaterTank(0.0,75.0,25.0);

        System.out.println("WaterTank 1 volume de départ: "+ waterTank1.getNiveauRemplissage());
        System.out.println("WaterTank 2 volume de départ: "+ waterTank2.getNiveauRemplissage());

        System.out.println("Volume total des WaterTanks : " + (waterTank1.getNiveauRemplissage() + waterTank2.getNiveauRemplissage()));

        waterTank2.setNiveauRemplissage(30);

        System.out.println("Volume total des WaterTanks : " + (waterTank1.getNiveauRemplissage() + waterTank2.getNiveauRemplissage()));

        waterTank1.setNiveauRemplissage(70);

        System.out.println("Volume total des WaterTanks : " + (waterTank1.getNiveauRemplissage() + waterTank2.getNiveauRemplissage()));

        waterTank2.setNiveauRemplissage(20);

        System.out.println("Volume total des WaterTanks : " + (waterTank1.getNiveauRemplissage() + waterTank2.getNiveauRemplissage()));



    }
}
