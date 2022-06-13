package com.mercadolibre.fp_be_java_hisp_w15_g05.repository;

import com.mercadolibre.fp_be_java_hisp_w15_g05.model.PurchaseOrder;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.PurchaseOrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPurchaseOrderRepository extends JpaRepository<PurchaseOrder,Integer> {
    @Query("FROM PurchaseOrderProduct pop JOIN FETCH pop.productById p WHERE pop.purchaseOrderById.order_id = :order_id")
    List<PurchaseOrderProduct> getListProducts(@Param("order_id") Integer idOrder);
}
