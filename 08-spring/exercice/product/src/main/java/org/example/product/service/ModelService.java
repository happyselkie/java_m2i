package org.example.product.service;

import java.util.List;
import java.util.UUID;

public interface ModelService<T> {

    List<T> findAll();

    T findById(UUID id);

    T save(T model);

    T delete(T model);
}
