package org.example.exercice_bonus_watertank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WaterTank {
    private int weightEmpty;
    private int maxCapacity;
    private int fillLevel;
    private String name;

    private static int watertankQuantity = 0;
    private static int totalFillLevel = 0;
    private static Map<String, WaterTank> waterTankList = new HashMap();

    public WaterTank(int weightEmpty, int maxCapacity, int fillLevel, String name) {
        this.weightEmpty = weightEmpty;
        this.maxCapacity = maxCapacity;
        this.fillLevel = fillLevel;
        this.name = name;
        totalFillLevel += fillLevel;
        watertankQuantity++;
        waterTankList.put(name, this);
    }

    public WaterTank(int weightEmpty, int maxCapacity) {
        this.weightEmpty = weightEmpty;
        this.maxCapacity = maxCapacity;
        this.fillLevel = 0;
    }

    public static int getTotalFillLevel(){
        return totalFillLevel;
    }

    public static int getWatertankQuantity() {
        return watertankQuantity;
    }

    public static Map<String, WaterTank> getWaterTankList() {
        return waterTankList;
    }

    public int getPoidsTotal(){
        return fillLevel + weightEmpty;
    }

    public int fill(int qt){
        if(qt < 0) {
            System.out.println("On ne peut pas remplir une quantité négative");
            return -1;
        }
        int rest = 0;

        if(this.fillLevel+qt > maxCapacity){
            rest = this.fillLevel+qt - maxCapacity;

            this.fillLevel = this.fillLevel+qt - rest;
            totalFillLevel += this.fillLevel+qt - rest;
        }else {
            this.fillLevel += qt;
            totalFillLevel += qt;
        }
        return rest;
    }

    public int empty(int qt){
        if(qt < 0) {
            System.out.println("On ne peut pas vider une quantité négative");
            return -1;
        }
        int rest = 0;
        if(qt > this.fillLevel){
            totalFillLevel -= this.fillLevel;
            this.fillLevel = 0;
            rest = qt - this.fillLevel;
        } else {
            this.fillLevel -= qt;
            totalFillLevel -= qt;
        }
        return rest;
    }

    public int getWeightEmpty() {
        return weightEmpty;
    }

    public void setWeightEmpty(int weightEmpty) {
        this.weightEmpty = weightEmpty;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getFillLevel() {
        return fillLevel;
    }

    public void setFillLevel(int fillLevel) {
        this.fillLevel = fillLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WaterTank{" +
                "weightEmpty=" + weightEmpty +
                ", maxCapacity=" + maxCapacity +
                ", fillLevel=" + fillLevel +
                ", name='" + name + '\'' +
                '}';
    }
}
