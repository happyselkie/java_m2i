package org.example.exercices_pattern.structural;


import com.sun.source.doctree.TextTree;
import org.example.exercices_pattern.structural.classes.*;

public class Main {
    public static void main(String[] args) {
        Text simpleText = new SimpleText();
        System.out.println(simpleText.transform("Coucou ! Ceci n'est pas un texte."));

        simpleText = new TextPrefix(simpleText, ">> -");
        System.out.println(simpleText.transform("Bonjour tout le monde !"));

        simpleText = new TextLower(simpleText);
        System.out.println(simpleText.transform("Coucou"));

        simpleText = new TextColor(simpleText, "blue");
        System.out.println(simpleText.transform("Bonjour tout le monde !"));
    }
}
