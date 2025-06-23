package org.example.demo_form.service;


import org.example.demo_form.model.Contact;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ContactService {

    // Un Service qui va utiliser un HashMap pour stocker les contacts

    private final Map<UUID, Contact> contacts;

    public ContactService(){
        // Initialisation du Hashmap
        contacts = new HashMap<>();
        // Creation de plusieurs contact que nous mettons dans le hasmap
        // Utilisation du builder pour la classe Contact fourni par lombok
        Contact contactA = Contact.builder()
                .id(UUID.randomUUID()) // creation d'un UUID aléatoire
                .name("Toto")
                .phone("0123456789")
                .age(18)
                .build();
        Contact contactB = Contact.builder()
                .id(UUID.randomUUID()) // creation d'un UUID aléatoire
                .name("Tata")
                .phone("9876543210")
                .age(81)
                .build();
        Contact contactC = Contact.builder()
                .id(UUID.randomUUID()) // creation d'un UUID aléatoire
                .name("Tutu")
                .phone("6543217890")
                .age(56)
                .build();
        // Insertion des contacts dans le HashMap (clé : id du contact, valeur : le contact)
        this.contacts.put(contactA.getId(),contactA);
        this.contacts.put(contactB.getId(),contactB);
        this.contacts.put(contactC.getId(),contactC);
    }

    // Recuperation de l'integralite des contacts
    public List<Contact> getAllContacts(){
        // utilisation du stream pour fournir tous les contact sous forme de List plutot que Hashmap
        return this.contacts.values().stream().toList();
    }

    // Trouver et renvoyer un contact par rapport a son id (UUID)
    public Contact getContactByID(UUID id){
        return this.contacts.get(id);
    }

    // Trouver un contact par rapport a son nom
    // Utilisation d'un stream pour parcourir les contact et trouver un contact par rapport a son nom
    public Contact getContactByName(String name){
        return this.contacts.values().stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);
    }

    public Contact saveContact(Contact contact){
        contact.setId(UUID.randomUUID());
        contacts.put(contact.getId(),contact);
        return contact;
    }

}
