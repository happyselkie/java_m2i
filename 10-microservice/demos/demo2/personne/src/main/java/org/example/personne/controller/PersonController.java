package org.example.personne.controller;

import org.example.personne.model.Address;
import org.example.personne.model.Person;
import org.example.personne.util.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/personne")
public class PersonController {

    @Autowired
    RestTemplate restTemplate;

    public PersonController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

   /* @GetMapping("/{id}")
    public Person getPerson(@PathVariable int id) {
        Person person = new Person();
        person.setId(id);
        person.setName("Toto");
        Address address = restTemplate.getForObject("http://localhost:8080/address/{id}", Address.class, id);
        person.setAddress(address);
        return person;
    }*/

    @GetMapping("/detail/{id}")
    public Person getPersonDetail(@PathVariable int id) {
        Person person = new Person();
        person.setId(id);
        person.setName("Tata");
        //http://localhost:8081/personne/detail/2
        RestClient<Address> adressClient = new RestClient<>("http://ADDRESS/address/"+id, restTemplate);
        Address address = adressClient.get(Address.class);
        person.setAddress(address);
        return person;
    }

}
