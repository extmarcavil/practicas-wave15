package com.meli.blog.repository;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<T, ID> {

    void save(T t);

    void update(T t);

    List<T> findAll();

    Optional<T> findById(ID id);

    boolean exists(T t);

}
