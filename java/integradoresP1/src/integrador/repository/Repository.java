package integrador.repository;

import java.util.List;

public interface Repository <T,I>{

    List<T> findAll();
    T find(I id);
    T delete(I id);
    T insert(T t);
    T update(I id, T t);
}
