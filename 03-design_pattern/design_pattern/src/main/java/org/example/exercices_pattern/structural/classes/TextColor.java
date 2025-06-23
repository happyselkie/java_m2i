package org.example.exercices_pattern.structural.classes;

public class TextColor extends TextDecorator{

    private String color;

    public TextColor(Text text, String color) {
        super(text);

        switch (color){
            case "red" -> this.color = Colors.ANSI_RED;
            case "black" -> this.color = Colors.ANSI_BLACK;
            case "blue" -> this.color = Colors.ANSI_BLUE;
            case "cyan" -> this.color = Colors.ANSI_CYAN;
            case "green" -> this.color = Colors.ANSI_GREEN;
            case "purple" -> this.color = Colors.ANSI_PURPLE;
            case "white" -> this.color = Colors.ANSI_WHITE;
            case "yellow" -> this.color = Colors.ANSI_YELLOW;
        }
    }

    @Override
    public String transform(String input) {
        return color + super.transform(input) + Colors.ANSI_RESET;
    }
}
