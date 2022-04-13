package supermercado.repository;

import java.util.Optional;

public interface CrudRepository<T> {
    void guardar(T objeto);
    void mostrarPantalla();
    Optional<T> buscar(String id);
    void eliminar(String id);
}
