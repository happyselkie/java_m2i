package org.example.rest_todo.repository;

import org.example.rest_todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRespository extends JpaRepository<Todo, Long> {
    public List<Todo> findByCompleted(boolean completed);
}
