package org.example.rest_todo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.rest_todo.dto.TodoResponseDto;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    private LocalDate date;

    private Boolean completed;


    public TodoResponseDto entityToDto() {
        return TodoResponseDto.builder()
                .id(getId())
                .title(getTitle())
                .description(getDescription())
                .date(getDate())
                .completed(getCompleted())
                .build();
    }
}
