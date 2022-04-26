package repository;

import java.util.List;
import java.util.Optional;

public interface ICRUD<T> {
    void save(T objeto);
    void mostrar();
    Optional<T> buscar(Long id);
    void eliminar(Long id);
    List<T> todos();
}
