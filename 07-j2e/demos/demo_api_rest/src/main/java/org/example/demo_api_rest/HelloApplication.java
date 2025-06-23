package org.example.demo_api_rest;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

// annotation @ApplicationPath qui doit être ppliquée à un classe qui extends Application
// Le chemin de @ApplicationPath indique l'url de base où se trouve les ressources JAX-RS
// http://localhost:8080/demo_api_rest_war_exploded/api/ @ApplicationPath("/api")

@ApplicationPath("api") // Une ApplicationPath Vide renvoie à la racine
public class HelloApplication extends Application {

}