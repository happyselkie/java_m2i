package org.example.demo_base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String sayHello() {
        System.out.println("Hello World par la méthode sayHello");

        return "hello";
    }

    @RequestMapping("/persons")
    @ResponseBody
    public List<String> getPersons() {
        return List.of("Toto", "Tata", "Titi");
    }

    @RequestMapping("/home/person")
    public String personInfos(Model model) {
        model.addAttribute("firstname", "Toto");
        model.addAttribute("lastname", "Titi");
        List<String> persons = List.of("Toto", "Tata", "Titi");
        model.addAttribute("persons", persons);
        return "person/details";
    }

    @RequestMapping("/home/empty")
    public String personEmptyInfos(Model model) {
        model.addAttribute("firstname", "Toto");
        model.addAttribute("lastname", "Titi");
        List<String> persons = new ArrayList<>();
        model.addAttribute("persons", persons);
        return "person/details";
    }

}

