package org.example.exercices_pattern.factory;

import java.util.HashMap;
import java.util.Map;

public class BigFactory {

    private Map<String, AnimalFactory> factoryMap = new HashMap<>();

    public void saveFactory(String typeFactory,AnimalFactory factory){
        factoryMap.put(typeFactory, factory);
    };

    public Animal buildAnimal(String typeAnimal){
        return factoryMap.get(typeAnimal).createAnimal();
    }




}
