package repository;

import java.util.List;

public interface Repository<T> {
    T save(T object);
    T delete(T object);
    T deleteByIndex(Integer index);
    List<T> findAll();
    T findByIndex(Integer index);
    T findEquals(T object);
    T updateByIndex(Integer index, T object);
}
