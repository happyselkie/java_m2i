package org.example.demo_rest.dto;


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

    private String username;
    private String birthDateString;
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
