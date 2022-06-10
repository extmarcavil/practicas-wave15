package com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions;

public class BatchCurrentQuantityBiggerThanInitialQuantityException extends RuntimeException{

    public BatchCurrentQuantityBiggerThanInitialQuantityException(Long id) {
        super("La cantidad actual del lote con Id de producto " + id + " no debe ser mayor a la cantidad inicial");
    }

}