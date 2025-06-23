package org.example.demo_base.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("salutations")
@Profile("FR")
public class GreetingServiceFrench implements GreetingService {
    @Override
    public String greet() {
        return "Coucou le monde de greeting service french !";
    }
}
