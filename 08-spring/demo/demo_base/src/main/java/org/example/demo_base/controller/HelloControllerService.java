package org.example.demo_base.controller;

import org.example.demo_base.service.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloControllerService {

    private GreetingService greetingService;

   // public HelloControllerService(@Qualifier("greetings") GreetingService greetingService) {
    public HelloControllerService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }



    @RequestMapping("/hello-set")
    public String helloSet() {
        System.out.println(greetingService.greet());
        return "hello";
    }

    @RequestMapping("/hello-set-fr")
    public String helloSetFr() {
        System.out.println(greetingService.greet());
        return "hello";
    }

    @EventListener
    public void on(ContextStartedEvent event) {
        System.out.println("Context started");
    }


    @EventListener
    public void on(ContextRefreshedEvent event) {
        System.out.println("Context refreshed");
    }


    @EventListener
    public void on(ContextClosedEvent event) {
        System.out.println("Context closed");
    }


    @EventListener
    public void on(ContextStoppedEvent event) {
        System.out.println("Context stopped");
    }




}
