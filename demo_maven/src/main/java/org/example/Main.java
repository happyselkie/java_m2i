package org.example;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String name;

        try{
            name = FigletFont.convertOneLine("Franfran");
        } catch (IOException e){
            System.out.println(e.getMessage());
            name = "Franfran";
        }

        System.out.println(name);

    }
}