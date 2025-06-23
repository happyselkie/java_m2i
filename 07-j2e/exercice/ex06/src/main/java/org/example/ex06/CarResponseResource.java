package org.example.ex06;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.ex06.model.Car;
import org.example.ex06.service.CarService;

import java.util.List;

@Path("/carsresp")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarResponseResource {

    private CarService carService;

    @Inject
    public CarResponseResource(CarService service) {
        carService = service;
    }

    @GET
    public Response getCars() {
        if(carService.getCars().size() > 0) {
            return Response.ok(carService.getCars()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/details/{id}")
    public Response getCar(@PathParam("id") int id) {
        Car car = carService.getCar(id);
        if (car == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(car).build();
        }
    }

    @POST
    @Path("/create-with-params")
    public Response create(@QueryParam("brand") String brand, @QueryParam("year") int year, @QueryParam("color") String color) {
        Car car =  carService.save(brand, year, color);
        return Response.status(Response.Status.CREATED).entity(car).build();
    }


    @PUT
    @Path("/update/{id}")
    public Response updateCarWithParams(@PathParam("id") int id, @QueryParam("brand") String brand, @QueryParam("year") int year, @QueryParam("color") String color) {
        Car car = carService.update(id, brand, year, color);

        if (car == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(car).build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteCar(@PathParam("id") int id) {
        if(!carService.delete(id)){
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }


}
