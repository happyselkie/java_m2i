package org.example.cinematheque.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cinematheque.entity.Director;
import org.example.cinematheque.entity.Movie;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DirectorReceiveDto {

    @Size(min = 2, max = 20)
    private String firstName;

    @Size(min = 2, max = 20)
    private String lastName;

    @Size(min = 2, max = 20)
    private String nationality;

    @Pattern(regexp = "[0-9]{2}[-|\\/]{1}[0-9]{2}[-|\\/]{1}[0-9]{4}", message = "La date doit être au format dd-MM-yyyy")
    private String birthDate;

    public Director dtoToEntity(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return Director.builder()
                .firstName(getFirstName())
                .lastName(getLastName())
                .nationality(getNationality())
                .birthDate(LocalDate.parse(getBirthDate(), formatter))
                .build();

    }
}
