package repository;

import java.util.List;
import java.util.Optional;

public interface ICRUDRepository<T> {  //<T> -> Representa a un generico
    public void save(T object);
    public void mostrarPantalla();
    public Optional<T> buscar(Long id);
    public void eliminar (Long id);
    public List<T> traerElementos();
}
