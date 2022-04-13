package CrudRepo;

import java.util.List;
import java.util.Optional;

public interface CrudRepo<T> {
    void save (T objeto);
    void mostrarPantalla();
    Optional<T> buscar(String clave);
    void eliminar (String clave);
    List<T> mostrarTodos();
}
