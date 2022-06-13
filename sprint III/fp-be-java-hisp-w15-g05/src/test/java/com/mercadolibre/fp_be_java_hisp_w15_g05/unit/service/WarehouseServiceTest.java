package com.mercadolibre.fp_be_java_hisp_w15_g05.unit.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.mercadolibre.fp_be_java_hisp_w15_g05.exceptions.InvalidFieldException;
import com.mercadolibre.fp_be_java_hisp_w15_g05.model.Warehouse;
import com.mercadolibre.fp_be_java_hisp_w15_g05.repository.WarehouseRepository;
import com.mercadolibre.fp_be_java_hisp_w15_g05.service.WarehouseService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {WarehouseService.class})
@ExtendWith(SpringExtension.class)
class WarehouseServiceTest {
    @MockBean
    private WarehouseRepository warehouseRepository;

    @Autowired
    private WarehouseService warehouseService;


    @Test
    @DisplayName("Warehouse existe")
    void testGetExistingWarehouse() {
        Warehouse warehouse = new Warehouse();
        warehouse.setName("Warehouse");
        warehouse.setWarehouse_id(1);
        when(this.warehouseRepository.findByWarehouse_id((Integer) any())).thenReturn(warehouse);
        assertSame(warehouse, this.warehouseService.getExistingWarehouse(1));
        verify(this.warehouseRepository).findByWarehouse_id((Integer) any());
    }

    @Test
    @DisplayName("Warehouse excepcion")
    void testGetExistingWarehouse2() {

        when(this.warehouseRepository.findByWarehouse_id(1)).thenReturn(null);
        assertThrows(InvalidFieldException.class, () -> this.warehouseService.getExistingWarehouse(1));
        verify(this.warehouseRepository).findByWarehouse_id(1);

    }
}

