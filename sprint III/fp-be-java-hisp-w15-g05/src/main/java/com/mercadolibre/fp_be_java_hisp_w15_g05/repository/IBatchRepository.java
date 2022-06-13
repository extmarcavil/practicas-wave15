package com.mercadolibre.fp_be_java_hisp_w15_g05.repository;

import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBatchRepository extends JpaRepository<Batch,Long> {
    @Query(value = "SELECT b FROM Batch b WHERE b.product.product_id = :id")
    List<Batch> findAllByProductId(Integer id);
}
