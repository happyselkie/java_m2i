package org.example.demo_rest.controller;

import org.example.demo_rest.dto.UserReceiveDto;
import org.example.demo_rest.dto.UserResponseDto;
import org.example.demo_rest.entity.User;
import org.example.demo_rest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAll() { return ResponseEntity.ok(userService.get()); }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable Long id) { return ResponseEntity.ok(userService.get(id)); }

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserReceiveDto user) { return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(user)); }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable Long id, @RequestBody UserReceiveDto user) { return ResponseEntity.ok(userService.update(id, user));}

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok(String.format("Deleted user with ID %s", id));
    }


}
