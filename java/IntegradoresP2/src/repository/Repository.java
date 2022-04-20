package repository;

import java.util.List;

public interface Repository <T,I>{

    List<T> findAll();
    T find(I id);
    T delete(I id);
    void insert(T t);
    T update(I id, T t);
}
