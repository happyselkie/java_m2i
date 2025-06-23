package org.example.javastudentmanager.service;

import java.util.List;
import java.util.UUID;

public interface ModelService<T> {

    List<T> findAll();

    T findById(UUID id);

    T save(T model);

    T update(T model);

    boolean delete(T model);
}
