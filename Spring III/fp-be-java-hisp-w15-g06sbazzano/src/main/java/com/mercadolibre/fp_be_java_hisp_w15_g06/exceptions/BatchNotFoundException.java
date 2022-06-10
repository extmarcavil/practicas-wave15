package com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions;

public class BatchNotFoundException extends RuntimeException {

    public BatchNotFoundException() {
        super("No se encontraron lotes relacionados a este producto");
    }
}
