package ejercicioIntegradorSupermercado.repository;

import java.util.List;
import java.util.Optional;

public interface ICRUDRepository <T> {

    void guardar(T objeto);
    void mostrarEnPantalla();
    Optional<T> buscar(Long id);
    void eliminar(Long id);
    List<T> traerTodos();
}
