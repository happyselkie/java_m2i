package org.example.excercice_bonus_salarie_heritage;

import java.util.UUID;

public class SalarieLib {

    public static String createMatricule(){
       return UUID.randomUUID().toString();
    }

}
