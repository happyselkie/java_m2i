package org.example.rest_todo.controller;

import org.example.rest_todo.dto.TodoReceiveDto;
import org.example.rest_todo.dto.TodoResponseDto;
import org.example.rest_todo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<TodoResponseDto>> getAll() { return ResponseEntity.ok(todoService.get()); }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDto> getById(@PathVariable Long id) { return ResponseEntity.ok(todoService.get(id)); }

    @GetMapping("/completed/{bool}")
    public ResponseEntity<List<TodoResponseDto>> getCompleted(@PathVariable boolean bool) { return ResponseEntity.ok(todoService.getCompleted(bool)); }

    @PostMapping
    public ResponseEntity<TodoResponseDto> create(@RequestBody TodoReceiveDto todo) { return ResponseEntity.status(HttpStatus.CREATED).body(todoService.create(todo)); }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponseDto> update(@PathVariable Long id, @RequestBody TodoReceiveDto todo) { return ResponseEntity.ok(todoService.update(id, todo));}

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        todoService.delete(id);
        return ResponseEntity.ok(String.format("Deleted todo with ID %s", id));
    }


}
