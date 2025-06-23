package org.example.demo_api_rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/person")
public class PersonResource {

    PersonService personService;

    @Inject
    public PersonResource(PersonService service) {
        personService = service;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson() {
        return new Person(42, "toto", 25);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person createPerson(Person person) {
        person.setId(52);
        return person;
    }

    @POST
    @Path("/withservice")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person createPersonWithService(){
        return personService.save(55, "tutu", 99);
    }

    @POST
    @Path("/params")
    @Produces(MediaType.APPLICATION_JSON)
    public Person createPersonWithParams(@QueryParam("name")String name,@QueryParam("age") int age) {
        return personService.save(4, name, age);
    }


    @DELETE
    @Path("/delete/{id}")
    public int deletePerson(@PathParam("id") int id) {
        return id;
    }
}
