package org.example.cinematheque.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cinematheque.dto.MovieResponseDto;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String genre;

    private LocalDate releaseDate;

    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "director")
    private Director director;


    public MovieResponseDto entityToDto() {
        return MovieResponseDto.builder()
                .id(getId())
                .title(getTitle())
                .description(getDescription())
                .genre(getGenre())
                .releaseDate(getReleaseDate())
                .duration(getDuration())
                .director(getDirector())
                .build();
    }
}
