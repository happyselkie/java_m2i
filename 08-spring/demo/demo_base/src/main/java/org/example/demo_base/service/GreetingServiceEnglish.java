package org.example.demo_base.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("greetings")
@Profile("EN")
public class GreetingServiceEnglish implements GreetingService {

    @Override
    public String greet() {
        return "Hello World from greeting service english !";
    }
}
