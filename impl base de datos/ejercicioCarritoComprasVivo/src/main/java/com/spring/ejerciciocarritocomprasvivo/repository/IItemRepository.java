package com.spring.ejerciciocarritocomprasvivo.repository;

import com.spring.ejerciciocarritocomprasvivo.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemRepository extends JpaRepository<Item, Long> {
}
