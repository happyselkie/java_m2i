package org.example.cinematheque.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cinematheque.entity.Movie;
import org.example.cinematheque.exception.NotFoundException;
import org.example.cinematheque.repository.DirectorRepository;
import org.example.cinematheque.service.DirectorService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieReceiveDto {

    @Size(min = 3, max = 25, message = "Le titre doit être compris entre 3 et 25 caractères")
    private String title;

    @NotEmpty
    @NotBlank
    private String description;

    @NotEmpty
    @NotBlank
    private String genre;

    @Pattern(regexp = "[0-9]{2}[-|\\/]{1}[0-9]{2}[-|\\/]{1}[0-9]{4}", message = "La date doit être au format dd-MM-yyyy")
    private String releaseDate;

    @Positive(message = "La durée doit être un nombre positif")
    private Integer duration;

    @NotNull
    @Positive(message = "Veuillez insérer un id valide")
    private Long directorId;


    public Movie dtoToEntity(DirectorRepository directorRepository){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return Movie.builder()
                .title(getTitle()   )
                .description(getDescription())
                .genre(getGenre())
                .releaseDate(LocalDate.parse(getReleaseDate(), formatter))
                .duration(getDuration())
                .director(directorRepository.findById(getDirectorId()).orElseThrow(NotFoundException::new))
                .build();

    }
}
