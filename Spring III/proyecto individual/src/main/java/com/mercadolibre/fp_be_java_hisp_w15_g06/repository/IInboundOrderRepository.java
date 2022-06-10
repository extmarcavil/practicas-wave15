package com.mercadolibre.fp_be_java_hisp_w15_g06.repository;

import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Batch;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.InboundOrder;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Section;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface IInboundOrderRepository extends JpaRepository<InboundOrder, Long> {
    List<InboundOrder> findByWarehouseAndSection(Warehouse warehouse, Section section);
    List<InboundOrder> findByWarehouse(Warehouse warehouse);

}
