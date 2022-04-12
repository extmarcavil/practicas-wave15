import java.util.List;

public interface ICrudGeneral<T>{
    boolean Nuevo(T entity);

    boolean Eliminar(long Codigo);

    T Buscar(long Codigo);

    boolean Actualizar(T entity);

    List<T> BuscarTodo();
}
