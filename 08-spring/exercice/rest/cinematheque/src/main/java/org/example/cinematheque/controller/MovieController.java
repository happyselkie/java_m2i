package org.example.cinematheque.controller;

import jakarta.validation.Valid;
import org.example.cinematheque.dto.MovieReceiveDto;
import org.example.cinematheque.dto.MovieResponseDto;
import org.example.cinematheque.service.DirectorService;
import org.example.cinematheque.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movie")
public class MovieController {

    private final MovieService movieService;
    private final DirectorService directorService;

    public MovieController(MovieService movieService, DirectorService directorService) {
        this.movieService = movieService;
        this.directorService = directorService;
    }

    @GetMapping
    public ResponseEntity<List<MovieResponseDto>> getAll() { return ResponseEntity.ok(movieService.get()); }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponseDto> getById(@PathVariable Long id) { return ResponseEntity.ok(movieService.get(id)); }

    @GetMapping("/director/{directorName}")
    public ResponseEntity<List<MovieResponseDto>> getByDirector(@PathVariable String directorName) { return ResponseEntity.ok(movieService.getByDirector(directorName)); }

    @PostMapping
    public ResponseEntity<MovieResponseDto> create(@Valid @RequestBody MovieReceiveDto movie) { return ResponseEntity.status(HttpStatus.CREATED).body(movieService.create(movie)); }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponseDto> update(@PathVariable Long id, @RequestBody MovieReceiveDto movie) { return ResponseEntity.ok(movieService.update(id, movie));}

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        movieService.delete(id);
        return ResponseEntity.ok(String.format("Deleted movie with ID %s", id));
    }
}
