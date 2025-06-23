package org.example.demo_rest.service;

import org.example.demo_rest.dto.UserReceiveDto;
import org.example.demo_rest.dto.UserResponseDto;
import org.example.demo_rest.entity.User;
import org.example.demo_rest.exception.NotFoundException;
import org.example.demo_rest.repository.UserRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRespository userRespository;

    public UserService(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    public UserResponseDto create(UserReceiveDto userReceiveDto){ return userRespository.save(userReceiveDto.dtoToEntity()).entityToDto(); }

    public UserResponseDto get(Long id){ return userRespository.findById(id).orElseThrow(NotFoundException::new).entityToDto(); }

    public List<UserResponseDto> get(){
        /*List<User> users = userRespository.findAll();
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        for (User user : users) {
            userResponseDtos.add(user.entityToDto());
        }
        return userResponseDtos;*/

        /*Simplification avec stream : */
        return userRespository.findAll().stream().map(User::entityToDto).toList();
    }

    public UserResponseDto update(Long id, UserReceiveDto userReceiveDto){
        User userToUpdate = userRespository.findById(id).orElseThrow(NotFoundException::new);
        User userGet = userReceiveDto.dtoToEntity();
        userToUpdate.setUsername(userGet.getUsername());
        userToUpdate.setPassword(userGet.getPassword());
        userToUpdate.setBirthDate(userGet.getBirthDate());
        return userRespository.save(userToUpdate).entityToDto();
    }

    public void delete(Long id){ userRespository.deleteById(id); }

}
