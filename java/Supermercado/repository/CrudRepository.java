package Supermercado.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CrudRepository <T>{
    public void save(T objeto);
    public void mostrarDatos();
    public Optional<T> buscar(Long id);
    public void eliminar(Long id);
    public ArrayList<T> mostrarTodosObjetos();
}
