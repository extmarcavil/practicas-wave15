import java.util.List;

public interface CRUD <T>{

    void guardar(T objeto);
    T buscar (String objeto);
    void eliminar (String objeto);
    void mostrar();
    List<T> devolver();
}
