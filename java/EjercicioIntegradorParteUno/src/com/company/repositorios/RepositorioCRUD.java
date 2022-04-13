package com.company.repositorios;

import java.util.List;
import java.util.Optional;

public interface RepositorioCRUD <T> {

    public void save(T objeto);
    public void mostrarPantalla();
    public Optional<T> buscar(String id);
    public void eliminar(String id);
    public List<T> traerTodos();

}
