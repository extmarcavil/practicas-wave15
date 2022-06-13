package com.mercadolibre.fp_be_java_hisp_w15_g05.repository;

import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Product;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.SectionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Repositorio encargado de recuperar productos por su section type
 */
@Repository
public interface IProductRepository extends JpaRepository <Product,Integer>{

    @Query("FROM PurchaseOrderProduct pop JOIN FETCH pop.productById p WHERE pop.purchaseOrderProdNumber = :order_id")
    List<Product> getListProducts(@Param("order_id") Integer idOrder);

    List<Product> findAllByType(SectionType type);

    @Query("FROM Product p WHERE p.product_id = :id")
    Optional<Product> findById(@Param("id") Integer id);
}
