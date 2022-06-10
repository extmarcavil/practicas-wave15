package com.mercadolibre.fp_be_java_hisp_w15_g06.service;

import com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions.ProductNotFoundException;
import com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions.ProductNotFoundInAnyWarehouseException;
import com.mercadolibre.fp_be_java_hisp_w15_g06.repository.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class WarehouseServiceImplTest {

    @Mock
    private ProductRepository productRepository;
    @Mock
    private IBatchRepository batchRepository;

    @Test
    void whenNotFoundProductNotFound_thenAnExceptionIsThrown() {
        Long productId = 90L;

        when(productRepository.findById(any())).thenThrow(new ProductNotFoundException(productId));

        assertThatThrownBy(() -> productRepository.findById(productId))
                .isInstanceOf(ProductNotFoundException.class)
                .hasMessage("Producto con ID: " + productId + " no existe.");
    }

    @Test
    void whenNotFoundProductInAnyWarehouse_thenAnExceptionIsThrown() {
        Long productId = 90L;
        when(batchRepository.findByProduct(any())).thenThrow(new ProductNotFoundInAnyWarehouseException(productId));

        assertThatThrownBy(() -> batchRepository.findByProduct(any()))
                .isInstanceOf(ProductNotFoundInAnyWarehouseException.class)
                .hasMessage("Producto con ID: " + productId + " no existe en ningún warehouse.");
    }

}