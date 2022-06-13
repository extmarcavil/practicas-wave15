package com.mercadolibre.fp_be_java_hisp_w15_g05.service;

import com.mercadolibre.fp_be_java_hisp_w15_g05.exceptions.InvalidFieldException;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Warehouse;
import com.mercadolibre.fp_be_java_hisp_w15_g05.repository.WarehouseRepository;
import org.springframework.stereotype.Service;

@Service
public class WarehouseService implements IWarehouseService {

    private WarehouseRepository warehouseRepository;

    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public Warehouse getExistingWarehouse(Integer id) {
        Warehouse warehouse = warehouseRepository.findByWarehouse_id(Integer.valueOf(id));
        if(warehouse == null)
            throw new InvalidFieldException("El Warehouse con código " + id + " no existe");
        return warehouse;
    }
}
