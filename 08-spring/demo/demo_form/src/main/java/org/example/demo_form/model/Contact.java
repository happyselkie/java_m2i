package org.example.demo_form.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    // Utilisation d'un UUID comme ID pour les entites Contact
    // La classe UUID est disponible dans java util
    // https://www.uuidgenerator.net/
    private UUID id;
    private String name;
    private String phone;
    private int age;
}
