package com.spring.ejerciciocarritocomprasvivo.repository;

import com.spring.ejerciciocarritocomprasvivo.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Long> {
}
