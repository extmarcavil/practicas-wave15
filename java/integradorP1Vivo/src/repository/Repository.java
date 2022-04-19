package repository;

import java.util.List;

public interface Repository<T,V> {
    T findById(V id);
    T create(T t);
    List<T> findAll();
}
