package org.example.cinematheque.dto;


import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cinematheque.entity.Director;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MovieResponseDto {
    private Long id;

    private String title;
    private String description;
    private String genre;

    private LocalDate releaseDate;

    private Integer duration;

    private Director director;

}
