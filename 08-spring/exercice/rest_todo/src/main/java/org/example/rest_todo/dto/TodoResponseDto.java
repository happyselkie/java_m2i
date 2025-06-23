package org.example.rest_todo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TodoResponseDto {
    private Long id;

    private String title;
    private String description;

    private LocalDate date;

    private Boolean completed;
}
