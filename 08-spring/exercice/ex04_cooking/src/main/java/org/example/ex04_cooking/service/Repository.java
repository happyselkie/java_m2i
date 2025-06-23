package org.example.ex04_cooking.service;

import java.util.List;
import java.util.UUID;

public interface Repository<T> {

    List<T> findAll();

    T findById(UUID id);

    T save(T entity);

    T update(T entity);

    boolean delete(T entity);
}
