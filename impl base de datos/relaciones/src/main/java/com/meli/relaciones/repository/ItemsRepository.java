package com.meli.relaciones.repository;

import com.meli.relaciones.entities.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<Items,Long> {
}
