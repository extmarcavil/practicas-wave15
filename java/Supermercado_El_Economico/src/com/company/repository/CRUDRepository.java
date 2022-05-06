package com.company.repository;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository<T> {

    public void save(T obj);

    public void mostrarPorPantalla();

    public Optional<T> buscarPorId(int dni);

    public void delete(int dni);

    public List<T> mostrarTodos();
}
