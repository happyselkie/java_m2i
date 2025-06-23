package org.example.exercices_pattern.structural.classes;

public class TextUpper extends TextDecorator{

    public TextUpper(Text text) {
        super(text);
    }

    @Override
    public String transform(String input) {
        return super.transform(input).toUpperCase();
    }
}
