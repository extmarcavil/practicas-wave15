package com.mercadolibre.fp_be_java_hisp_w15_g05.repository;

import com.mercadolibre.fp_be_java_hisp_w15_g05.model.PurchaseOrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPurchaseOrderProductRepository extends JpaRepository<PurchaseOrderProduct,Integer> {
    @Query(value = "select pop from PurchaseOrderProduct pop where pop.purchaseOrderById.order_id = :id")
    List<PurchaseOrderProduct> findAllByPurchaseOrderId(@Param("id") Integer id);
}
