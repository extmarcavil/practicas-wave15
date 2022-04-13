package repositories;

import models.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EntityRepository<T extends Entity> {
    private List<T> entities = new ArrayList<>();
    private Long nextId = 1L;

    public Optional<T> findById(Long id) {
        return this.entities
                .stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    public List<T> findAll() {
        return this.entities;
    }

    public boolean existsById(Long id) {
        return this.findById(id).isPresent();
    }

    public T save(T entity) {
        if (this.existsById(entity.getId())) {
            this.removeById(entity.getId());
        } else {
            entity.setId(this.nextId);
            this.nextId++;
        }
        this.entities.add(entity);
        return entity;
    }

    public boolean removeById(Long id) {
        int prevSize = this.entities.size();

        this.entities = this.entities
                .stream()
                .filter(c -> !c.getId().equals(id))
                .collect(Collectors.toList());

        return prevSize != this.entities.size();
    }
}
