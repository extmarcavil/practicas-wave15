package com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions;

public class PurchaseOrderNotFoundException extends RuntimeException{

    public PurchaseOrderNotFoundException(Long id) {
        super("PurchaseOrder con ID: "+id+" no se ha encontrado");
    }
}
