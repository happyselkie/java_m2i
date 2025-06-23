package org.example.exercice2;

import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Film film1 = new Film("La Haine", "Mathieu Kassovitz", LocalDate.of(1995, 5, 31), "Drame");
        Film film2 = new Film("Avatar 2", "James Cameron",LocalDate.of(2022, 12, 14), "Action");

        System.out.println(film1);
        System.out.println(film2);
    }
}
