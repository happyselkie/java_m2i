package org.example;

import org.example.exception.NotFoundException;

import java.util.List;

public class RechercheVille {
    private List<String> villes;

    public RechercheVille(List<String> villes) {
        this.villes = villes;
    }

    public List<String> rechercher(String mot)  {
        if (mot.length() < 2){
            if (mot.equals("*")) return villes;
            throw new NotFoundException("Cette ville n'existe pas");
        }
        return villes.stream().filter(v -> v.toLowerCase().contains(mot.toLowerCase())).toList();
    }
}
