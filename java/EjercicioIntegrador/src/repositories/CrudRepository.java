package repositories;

import java.util.List;

public interface CrudRepository<T, J> {
    T findById(J id);
    List<T> findAll();
    T save(T entity);
    boolean deleteById(J id);
}
