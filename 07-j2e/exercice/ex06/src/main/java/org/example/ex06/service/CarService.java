package org.example.ex06.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.ex06.model.Car;
import org.example.ex06.repository.CarRepository;
import org.example.ex06.util.HibernateSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

@ApplicationScoped
public class CarService {

    private CarRepository carRepository;
    private SessionFactory sessionFactory;
    private Session session;

    public CarService() {
        this.sessionFactory = HibernateSession.getSessionFactory();
    }

    public Car getCar(int id){
        Car car = null;
        session = sessionFactory.openSession();
        carRepository = new CarRepository(session);
        try {
            car = carRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return car;
    }

    public boolean createCar(String brand, int year, String color){
        boolean result = false;
        session = sessionFactory.openSession();
        session.beginTransaction();
        carRepository = new CarRepository(session);
        Car car = new Car(brand,year,color);
        try {
            carRepository.create(car);
            session.getTransaction().commit();
            result = true;
        }catch (Exception e){
            try {
                session.getTransaction().rollback();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }finally {
            session.close();
        }
        return result;
    }


    public List<Car> getCars(){
        List<Car> cars = null;
        session = sessionFactory.openSession();
        carRepository = new CarRepository(session);
        try {
            cars = carRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return cars;
    }

    public Car save(String brand,int year, String color) {
        Car car = new Car(brand, year, color);
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(car);
            session.getTransaction().commit();
            return car;
        }catch (Exception ex){
            session.getTransaction().rollback();
            return null;
        }finally {
            session.close();
        }
    }

    public Car update(int id, String brand, int year, String color) {
        Car car = getCar(id);
        car.setBrand(brand);
        car.setYear(year);
        car.setColor(color);
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.merge(car);
            session.getTransaction().commit();
            return car;
        }catch (Exception ex){
            session.getTransaction().rollback();
            return null;
        }finally {
            session.close();
        }
    }

    public boolean delete(int id) {
        Car car = getCar(id);
        if(car !=null){
            try{
                session = sessionFactory.openSession();
                session.beginTransaction();
                session.remove(car);
                session.getTransaction().commit();
                return true;
            }catch (Exception ex){
                session.getTransaction().rollback();
                return false;
            }
            finally {
                session.close();
            }
        }else{
            System.out.println("Element at id : "+id+" not found");
            return false;
        }
    }


}
