package org.example.personne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PersonneApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonneApplication.class, args);
    }

}
