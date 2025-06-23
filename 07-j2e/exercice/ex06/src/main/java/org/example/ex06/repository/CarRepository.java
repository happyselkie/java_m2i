package org.example.ex06.repository;

import org.example.ex06.model.Car;
import org.hibernate.Session;

import java.util.List;

public class CarRepository extends Repository<Car>{

    public CarRepository(Session session) {
        super(session);
    }

    @Override
    public Car findById(int id) {
        return session.get(Car.class,id);
    }

    @Override
    public List<Car> findAll() {
        return session.createQuery("from Car",Car.class).list();
    }
}
