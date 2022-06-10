package com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions;

public class BatchMinTempBiggerThanCurrentTempException extends RuntimeException{

    public BatchMinTempBiggerThanCurrentTempException(Long productId) {
        super("La temperatura minima del lote con Id de producto " + productId + " no debe ser mayor a la temperatura actual");
    }

}