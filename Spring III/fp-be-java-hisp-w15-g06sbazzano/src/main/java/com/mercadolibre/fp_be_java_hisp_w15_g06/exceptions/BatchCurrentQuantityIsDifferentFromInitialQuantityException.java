package com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions;

public class BatchCurrentQuantityIsDifferentFromInitialQuantityException extends RuntimeException{

    public BatchCurrentQuantityIsDifferentFromInitialQuantityException(Long id) {
        super("La cantidad actual del lote con Id de producto " + id + " no debe ser distinta a la cantidad inicial");
    }

}