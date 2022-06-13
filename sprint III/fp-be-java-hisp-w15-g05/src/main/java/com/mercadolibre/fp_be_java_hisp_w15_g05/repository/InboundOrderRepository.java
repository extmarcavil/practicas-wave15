package com.mercadolibre.fp_be_java_hisp_w15_g05.repository;

import com.mercadolibre.fp_be_java_hisp_w15_g05.model.InboundOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InboundOrderRepository extends JpaRepository<InboundOrder, Long> {


}
