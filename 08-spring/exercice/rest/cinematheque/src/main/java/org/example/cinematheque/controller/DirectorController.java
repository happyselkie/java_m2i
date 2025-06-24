package org.example.cinematheque.controller;

import jakarta.validation.Valid;
import org.example.cinematheque.dto.DirectorReceiveDto;
import org.example.cinematheque.dto.DirectorResponseDto;
import org.example.cinematheque.service.DirectorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/director")
public class DirectorController {

    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping
    public ResponseEntity<List<DirectorResponseDto>> getAll() { return ResponseEntity.ok(directorService.get()); }

    @GetMapping("/{id}")
    public ResponseEntity<DirectorResponseDto> getById(@PathVariable Long id) { return ResponseEntity.ok(directorService.get(id)); }

    @PostMapping
    public ResponseEntity<DirectorResponseDto> create(@Valid @RequestBody DirectorReceiveDto director) { return ResponseEntity.status(HttpStatus.CREATED).body(directorService.create(director)); }

    @PutMapping("/{id}")
    public ResponseEntity<DirectorResponseDto> update(@PathVariable Long id, @RequestBody DirectorReceiveDto director) { return ResponseEntity.ok(directorService.update(id, director));}

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        directorService.delete(id);
        return ResponseEntity.ok(String.format("Deleted director with ID %s", id));
    }

}
