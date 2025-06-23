package org.example.demo_validation.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

    private Long id;

    @NotNull
    @NotBlank(message = "Ce champs ne doit pas être vide !")
    private String firstName;

    @NotNull
    @Size(min = 3, max = 35, message = "3 à 35 lettres autorisés")
    private String lastName;

    @Min(18)
    @Max(77)
    private Integer age;
}
