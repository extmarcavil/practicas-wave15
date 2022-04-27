package repository;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<K extends Number, T> {

    void save(T entity);

    void save(T... entity);

    void delete(T entity);

    Optional<T> findById(K id);

    List<T> getAll();

    boolean exists(T entity);
}
