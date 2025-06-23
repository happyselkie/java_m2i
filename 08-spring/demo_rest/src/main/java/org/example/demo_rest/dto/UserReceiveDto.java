package org.example.demo_rest.dto;


import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.demo_rest.entity.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserReceiveDto {

    @Size(min = 3, max = 25, message = "La date doit être comprise entre 3 et 25")
    private String username;

    @Pattern(regexp = "[0-9]{2}[-|\\/]{1}[0-9]{2}[-|\\/]{1}[0-9]{4}", message = "La date doit être au format dd-MM-yyyy")
    private String birthDateString;

    @Size(min = 4, message = "Le mot de passe doit faire au moins 4 characteres")
    private String password;

    public User dtoToEntity(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return User.builder()
                .username(getUsername())
                .password(getPassword())
                .birthDate(LocalDate.parse(getBirthDateString(), formatter))
                .build();

    }
}
