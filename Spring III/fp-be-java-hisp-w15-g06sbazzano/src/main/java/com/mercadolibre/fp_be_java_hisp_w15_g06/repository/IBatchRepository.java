package com.mercadolibre.fp_be_java_hisp_w15_g06.repository;

import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Batch;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.InboundOrder;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IBatchRepository extends JpaRepository<Batch, Long> {

    Optional<Batch> findByIdAndInboundOrder(Long id, InboundOrder inboundOrderId);
    List<Batch> findAllByDueDateBetween(LocalDate today, LocalDate dueDate);
    List<Batch> findByInboundOrder(InboundOrder inboundOrder);
    Optional<List<Batch>> findByProduct(Product product);

}
