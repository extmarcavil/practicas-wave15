package implementacion;

import java.util.List;
import java.util.Optional;

public interface CRUD <T>{

    public void save (T objeto);
    public void mostrar();
    public Optional<T> buscar (String id);
    public void eliminar (String id);
    public List<T> traerTodos();
}
