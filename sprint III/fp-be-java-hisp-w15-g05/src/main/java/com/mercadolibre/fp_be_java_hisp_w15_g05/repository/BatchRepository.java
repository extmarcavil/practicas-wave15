package com.mercadolibre.fp_be_java_hisp_w15_g05.repository;

import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Batch;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Product;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BatchRepository extends JpaRepository<Batch, Long> {

    @Query("FROM Batch b WHERE b.batch_number = :batchNumber")
    Batch findByBatch_number(@Param("batchNumber") Integer batchNumber);

    @Query("FROM Batch b WHERE b.product = :product")
    List<Batch> findAllByProductId(@Param("product") Product product);

}
