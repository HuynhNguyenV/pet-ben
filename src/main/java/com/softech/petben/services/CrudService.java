package com.softech.petben.services;

import java.util.List;
import java.util.Set;

public interface CrudService<T, ID> {
    Set<T> findAll();

    List<T> search(String name);

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);

}
