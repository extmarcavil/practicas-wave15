package com.meli.studenttest.repository;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<ID, T> {

    void save(T entity);

    boolean delete(ID id);

    boolean exists(T entity);

    Optional<T> findById(ID id);

    List<T> findAll();

    void update(T t);
}
