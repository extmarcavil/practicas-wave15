package com.company.repository;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository<T> {
        public void save(T object);
        public void showScreen();
        public Optional<T> search (String id);
        public void delete (String id);
        public List<T> getAll();
}
