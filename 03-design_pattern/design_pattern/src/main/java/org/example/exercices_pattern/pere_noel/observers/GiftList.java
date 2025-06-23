package org.example.exercices_pattern.pere_noel.observers;

import org.example.exercices_pattern.pere_noel.factories.Toy;

import java.util.ArrayList;
import java.util.List;

public class GiftList implements Observer{

    private String name;
    private List<Toy> toys = new ArrayList<>();

    public GiftList(String name) {
        this.name = name;
    }

    @Override
    public void notify(Toy toy) {
        System.out.println("#################### Un cadeau a été ajouté sur la liste "+name+": " + toy + " #######################");
        toys.add(toy);
    }

    public List<Toy> getGiftList(){
        return toys;
    }
}
