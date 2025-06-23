package org.example.demo_form.controller;


import org.example.demo_form.model.Contact;
import org.example.demo_form.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class ContactController {

    private final ContactService contactService;

    // Injection de mon contactservice a mon controlleur
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping // page disponible a la racine de l'application @GetMapping("/")
    public String homePage(){
        return "pagea";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Contact> contacts = contactService.getAllContacts(); // recuperation de tous les contacts grace au service
        model.addAttribute("contacts",contacts); // envoie de ma liste de contacts a ma vue
        return "pageb";
    }

    // Path Variable
    // Variable de chemin
    // {contactId} est une variable d'URL transmise dynamiquement
    @GetMapping("/detail/{contactId}")
    // Avec l'annotation @PathVariable en parametre de ma methode je recupere cette variable
    public String detailPage(@PathVariable("contactId") UUID contactId, Model model){
        // j'utilise mon service pour trouver le contact correspondant
        Contact contact = contactService.getContactByID(contactId);
        // j'envoie le contact touver a ma page
        model.addAttribute("contact",contact);
        return "pagec";
    }

    // Query Parameter
    // Variable de requete
    // Gere les requette ver l'url /search
    @GetMapping("/search") // search?name=Toto
    // Avec l'annotation @RequestParam je recupere les parametres de requete (apres ?)
    // et avec required = false je precise que ce est optionnel (non obligatoire)
    // il est possible recuperer autant de variable de requete que l'on souhaite
    public String showContact(@RequestParam(value = "name",required = false) String name, Model model){
        // j'utilise mon service pour trouver un contact avec un nom correspondant
        Contact contact = contactService.getContactByName(name);
        if (contact != null){ // si j'ai bien trouver un contact
            model.addAttribute("contact",contact);
            return "pagec";
        }else { // si je n'ai pas trouve de contact je revoie vers la route /list
            return "redirect:/list";
        }
    }

    @GetMapping("/formget")
    public String showFormGet(){
        return "form/formone";
    }

    @GetMapping("/add")
    public String recupFormGet(@RequestParam("name") String name,
                               @RequestParam("age") int age,
                               @RequestParam("phone") String phone,
                               Model model){
        Contact contact = Contact.builder().name(name).phone(phone).age(age).build();
        contactService.saveContact(contact);
        return "redirect:/list";
    }


    @GetMapping("/formpost")
    public String showFormPost(Model model){
        model.addAttribute("contact", new Contact());
        return "form/formtwo";
    }

    @PostMapping("/add")
    public String recupFormPost(@ModelAttribute Contact contact){
        contactService.saveContact(contact);
        return "redirect:/list";
    }


}
