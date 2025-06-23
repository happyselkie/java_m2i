package org.example.rest_todo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.rest_todo.entity.Todo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoReceiveDto {

    private String title;
    private String description;

    private String date;

    private Boolean completed;

    public Todo dtoToEntity(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return Todo.builder()
                .title(getTitle())
                .description(getDescription())
                .date(LocalDate.parse(getDate(), formatter))
                .completed(getCompleted())
                .build();

    }
}
