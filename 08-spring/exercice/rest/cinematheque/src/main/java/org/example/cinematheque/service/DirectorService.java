package org.example.cinematheque.service;

import org.example.cinematheque.dto.DirectorReceiveDto;
import org.example.cinematheque.dto.DirectorResponseDto;
import org.example.cinematheque.entity.Director;
import org.example.cinematheque.exception.NotFoundException;
import org.example.cinematheque.repository.DirectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {

    private final DirectorRepository directorRepository;

    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public DirectorResponseDto create(DirectorReceiveDto directorReceiveDto){ return directorRepository.save(directorReceiveDto.dtoToEntity()).entityToDto(); }

    public DirectorResponseDto get(Long id){ return directorRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto(); }

    public Director getDirector(Long id){ return directorRepository.findById(id).orElseThrow(NotFoundException::new); }

    public List<DirectorResponseDto> get(){
        return directorRepository.findAll().stream().map(Director::entityToDto).toList();
    }

    public DirectorResponseDto update(Long id, DirectorReceiveDto DirectorReceiveDto){
        Director directorToUpdate = directorRepository.findById(id).orElseThrow(NotFoundException::new);
        Director directorGet = DirectorReceiveDto.dtoToEntity();
        directorToUpdate.setFirstName(directorGet.getFirstName());
        directorToUpdate.setLastName(directorGet.getLastName());
        directorToUpdate.setNationality(directorGet.getNationality());
        directorToUpdate.setBirthDate(directorGet.getBirthDate());
        return directorRepository.save(directorToUpdate).entityToDto();
    }

    public void delete(Long id){ directorRepository.deleteById(id); }
}
