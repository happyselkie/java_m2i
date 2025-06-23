package org.example.demo_validation.controller;

import jakarta.validation.Valid;
import org.example.demo_validation.model.Contact;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class ContactController {

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("contact", new Contact());
        return "form";
    }

    @PostMapping("/form")
    public String add(@Valid @ModelAttribute("contact") Contact contact, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "form";
        }
        return "form-confirm";
    }

    @GetMapping("/pb")
    public String pb(Model model) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
}
