package org.example.exercices_pattern.pere_noel;

import org.example.exercices_pattern.pere_noel.decorators.GiftRibbon;
import org.example.exercices_pattern.pere_noel.decorators.GiftWrapper;
import org.example.exercices_pattern.pere_noel.factories.FactoryPlant;
import org.example.exercices_pattern.pere_noel.factories.FurbyFactory;
import org.example.exercices_pattern.pere_noel.factories.GameboyFactory;
import org.example.exercices_pattern.pere_noel.factories.Toy;
import org.example.exercices_pattern.pere_noel.observers.*;

public class Main {
    public static void main(String[] args) {


        FactoryPlant factoryPlant = new FactoryPlant();
        factoryPlant.saveFactory("furby", new FurbyFactory());
        factoryPlant.saveFactory("gameboy", new GameboyFactory());

        Observer furbyObserver = new FurbyObserver("Les lutins qui s'occupent des furby");
        Observer gameboyObserver = new GameboyObserver("Les lutins qui s'occupent des gameboys");
        Observer giftList = new GiftList("Liste de cadeaux");
        Observer packageObserver = new PackageObserver("Les lutins qui s'occupent des colis");

        factoryPlant.addObserver(furbyObserver);
        factoryPlant.addObserver(gameboyObserver);
        factoryPlant.addObserver(giftList);

        Toy furbyForTom = factoryPlant.buildToy("furby", "Tom");
        Toy gameboyForLily = factoryPlant.buildToy("gameboy", "Lily");
        Toy furbyForLucy = factoryPlant.buildToy("furby", "Lucy");
        Toy gameboyForNathan = factoryPlant.buildToy("gameboy", "Nathan");


        furbyForLucy = new GiftWrapper(furbyForLucy, "à lignes");
        System.out.printf(furbyForLucy.getToy()+"\n");

        gameboyForLily = new GiftRibbon(gameboyForLily, "rouge");
        System.out.printf(gameboyForLily.getToy()+"\n");
        gameboyForLily = new GiftWrapper(gameboyForLily, "à pois verts");
        System.out.println(gameboyForLily.getToy());
    }
}
