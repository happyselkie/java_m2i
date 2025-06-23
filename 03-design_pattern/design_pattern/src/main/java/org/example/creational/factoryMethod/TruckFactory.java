package org.example.creational.factoryMethod;

public class TruckFactory extends VehicleFactory{

    @Override
    public Vehicle createVehicle() {
        return new Truck();
    }

}
