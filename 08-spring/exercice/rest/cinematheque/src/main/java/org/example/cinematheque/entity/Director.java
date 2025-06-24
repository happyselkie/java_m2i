package org.example.cinematheque.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cinematheque.dto.DirectorResponseDto;
import org.example.cinematheque.dto.MovieResponseDto;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String nationality;

    private LocalDate birthDate;

    public DirectorResponseDto entityToDto() {
        return DirectorResponseDto.builder()
                .id(getId())
                .firstName(getFirstName())
                .lastName(getLastName())
                .nationality(getNationality())
                .birthDate(getBirthDate())
                .build();
    }
}
