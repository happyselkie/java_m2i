package org.example.rest_todo.service;

import org.example.rest_todo.dto.TodoReceiveDto;
import org.example.rest_todo.dto.TodoResponseDto;
import org.example.rest_todo.entity.Todo;
import org.example.rest_todo.exception.NotFoundException;
import org.example.rest_todo.repository.TodoRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRespository todoRespository;

    public TodoService(TodoRespository todoRespository) {
        this.todoRespository = todoRespository;
    }

    public TodoResponseDto create(TodoReceiveDto todoReceiveDto){ return todoRespository.save(todoReceiveDto.dtoToEntity()).entityToDto(); }

    public TodoResponseDto get(Long id){ return todoRespository.findById(id).orElseThrow(NotFoundException::new).entityToDto(); }

    public List<TodoResponseDto> get(){
        return todoRespository.findAll().stream().map(Todo::entityToDto).toList();
    }

    public List<TodoResponseDto> getCompleted(boolean completed){
        return todoRespository.findByCompleted(completed).stream().map(Todo::entityToDto).toList();
    }

    public TodoResponseDto update(Long id, TodoReceiveDto TodoReceiveDto){
        Todo todoToUpdate = todoRespository.findById(id).orElseThrow(NotFoundException::new);
        Todo todoGet = TodoReceiveDto.dtoToEntity();
        todoToUpdate.setTitle(todoGet.getTitle());
        todoToUpdate.setDescription(todoGet.getDescription());
        todoToUpdate.setDate(todoGet.getDate());
        todoToUpdate.setCompleted(todoGet.getCompleted());
        return todoRespository.save(todoToUpdate).entityToDto();
    }

    public void delete(Long id){ todoRespository.deleteById(id); }
}
