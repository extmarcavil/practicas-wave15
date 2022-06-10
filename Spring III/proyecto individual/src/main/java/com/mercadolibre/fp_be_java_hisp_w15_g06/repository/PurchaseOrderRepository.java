package com.mercadolibre.fp_be_java_hisp_w15_g06.repository;

import com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions.PurchaseOrderNotFoundException;
import com.mercadolibre.fp_be_java_hisp_w15_g06.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {

    default PurchaseOrder getPurchaserOrderById(Long id) {
        return findById(id).orElseThrow(() -> new PurchaseOrderNotFoundException(id));
    }

}
