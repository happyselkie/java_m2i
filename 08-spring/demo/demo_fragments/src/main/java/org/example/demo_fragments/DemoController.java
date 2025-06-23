package org.example.demo_fragments;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/page")
    public String page() {
        return "page";
    }
}
