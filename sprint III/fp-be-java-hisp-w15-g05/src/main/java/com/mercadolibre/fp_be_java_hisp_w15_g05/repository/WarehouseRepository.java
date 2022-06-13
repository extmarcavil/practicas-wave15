package com.mercadolibre.fp_be_java_hisp_w15_g05.repository;

import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {

    @Query("FROM Warehouse w WHERE w.warehouse_id = :code")
    Warehouse findByWarehouse_id(@Param("code") Integer code);
}
