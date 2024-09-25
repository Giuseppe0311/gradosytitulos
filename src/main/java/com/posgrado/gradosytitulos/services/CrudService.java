package com.posgrado.gradosytitulos.services;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {
    T create(T obj);

    List<T> findAll();

    Optional<T> getById(ID id);

    T update(ID id, T obj);

    void delete(ID id);
}
