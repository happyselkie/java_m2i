package org.example;

import org.example.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class RechercheVille {
    private List<String> villes;

    public RechercheVille() {
        this.villes = List.of("Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver", "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok", "Hong Kong", "Dubaï", "Rome", "Istanbul");
    }

    public List<String> rechercher(String mot)  {
        if (mot.length() < 2){
            if (mot.equals("*")) return villes;
            throw new NotFoundException("Cette ville n'existe pas");
        }
        if (mot.length() == 2) {
            return villes.stream().filter(v -> v.toLowerCase().startsWith(mot.toLowerCase())).toList();
        } else {
            return villes.stream().filter(v -> v.toLowerCase().contains(mot.toLowerCase())).toList();
        }
    }

    public List<String> getVilles() {
        return villes;
    }
}
