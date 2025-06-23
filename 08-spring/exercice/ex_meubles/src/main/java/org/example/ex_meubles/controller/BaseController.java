package org.example.ex_meubles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {
    @GetMapping
    public String homePage(){
        return "home";
    }
}
