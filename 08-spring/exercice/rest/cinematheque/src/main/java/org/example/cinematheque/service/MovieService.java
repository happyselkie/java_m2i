package org.example.cinematheque.service;

import org.example.cinematheque.dto.MovieReceiveDto;
import org.example.cinematheque.dto.MovieResponseDto;
import org.example.cinematheque.entity.Director;
import org.example.cinematheque.entity.Movie;
import org.example.cinematheque.exception.NotFoundException;
import org.example.cinematheque.repository.DirectorRepository;
import org.example.cinematheque.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;

    public MovieService(MovieRepository movieRepository, DirectorRepository directorRepository) {
        this.movieRepository = movieRepository;
        this.directorRepository = directorRepository;
    }

    public MovieResponseDto create(MovieReceiveDto movieReceiveDto){
        return movieRepository.save(movieReceiveDto.dtoToEntity(directorRepository)).entityToDto();
    }

    public MovieResponseDto get(Long id){ return movieRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto(); }

    public List<MovieResponseDto> getByDirector(String director){
        List<Director> directors = directorRepository.findAll();
        Director directorToFind = directors.stream().filter(d -> d.getFirstName().equals(director) || d.getLastName().equals(director)).findFirst().orElse(null);

        return movieRepository.findByDirector(directorToFind).stream().map(Movie::entityToDto).toList();
    }

    public List<MovieResponseDto> get(){
        return movieRepository.findAll().stream().map(Movie::entityToDto).toList();
    }

    public MovieResponseDto update(Long id, MovieReceiveDto MovieReceiveDto){
        Movie movieToUpdate = movieRepository.findById(id).orElseThrow(NotFoundException::new);
        Movie movieGet = MovieReceiveDto.dtoToEntity(directorRepository);
        movieToUpdate.setTitle(movieGet.getTitle());
        movieToUpdate.setDescription(movieGet.getDescription());
        movieToUpdate.setGenre(movieGet.getGenre());
        movieToUpdate.setReleaseDate(movieGet.getReleaseDate());
        movieToUpdate.setDuration(movieGet.getDuration());
        return movieRepository.save(movieToUpdate).entityToDto();
    }

    public void delete(Long id){ movieRepository.deleteById(id); }

}
