package org.example.cinematheque.dto;


import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cinematheque.entity.Movie;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DirectorResponseDto {
    private Long id;

    private String firstName;
    private String lastName;
    private String nationality;

    private LocalDate birthDate;
}
