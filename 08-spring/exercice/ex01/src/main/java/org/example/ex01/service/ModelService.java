package org.example.ex01.service;

import java.util.List;

public interface ModelService<T> {

    List<T> findAll();

    T findById(int id);

    T find(T model);

    T save(T model);

    T delete(T model);
}
