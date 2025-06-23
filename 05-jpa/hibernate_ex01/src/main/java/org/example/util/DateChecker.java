package org.example.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateChecker {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static java.util.Date checkDate(String date) {
        boolean validDate = false;
        java.util.Date dateToCheck = new java.util.Date();

        while (!validDate){
            try {
                dateToCheck = dateFormat.parse(date);
                validDate = true;
            } catch (ParseException e) {
                System.out.println("Format de la date incorrect. Veuillez insérer une date correcte (dd/MM/yyyy): ");
            }
        }
        return dateToCheck;

    }

    public Date dateToSqlDate(String date) {
        java.util.Date dateToCheck = checkDate(date);
        return new java.sql.Date(dateToCheck.getTime());
    }

    public LocalDate checkLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean validDate = false;

        LocalDate toCheck = null;

        while (!validDate){
            try {
                toCheck = LocalDate.parse(date,formatter);
                validDate = true;

            } catch (Exception e) {
                System.out.println("Format de la date incorrect. Veuillez insérer une date correcte (dd/MM/yyyy): ");
            }
        }
        return toCheck;
    }

}
