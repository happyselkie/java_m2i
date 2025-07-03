package org.example.personne.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    private Integer id;

    private String street;
    private String city;
    private Integer postalCode;
    private String country;
}
