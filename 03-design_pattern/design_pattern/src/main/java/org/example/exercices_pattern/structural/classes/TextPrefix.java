package org.example.exercices_pattern.structural.classes;

public class TextPrefix extends TextDecorator{

    private String prefix;


    public TextPrefix(Text text, String prefix) {
        super(text);
        this.prefix = prefix;
    }

    @Override
    public String transform(String input) {
        return prefix+" "+super.transform(input);
    }
}
