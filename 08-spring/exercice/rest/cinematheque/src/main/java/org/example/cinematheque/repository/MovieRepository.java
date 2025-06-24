package org.example.cinematheque.repository;

import org.example.cinematheque.entity.Director;
import org.example.cinematheque.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByDirector(Director director);
}
