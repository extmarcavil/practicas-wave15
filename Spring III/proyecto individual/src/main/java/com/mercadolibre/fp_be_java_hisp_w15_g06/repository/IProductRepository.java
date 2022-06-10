package com.mercadolibre.fp_be_java_hisp_w15_g06.repository;

import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
}
