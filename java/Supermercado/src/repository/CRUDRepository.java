package repository;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository <T> {

    void guardar(T objeto);

    void mostrarPorPantalla();

    Optional<T> buscar(String id);

    void eliminar(String id);

    List<T> obtenerTodos();
}
