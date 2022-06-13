package com.mercadolibre.fp_be_java_hisp_w15_g05.service;

import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Warehouse;

public interface IWarehouseService {

    Warehouse getExistingWarehouse(Integer id);
}
