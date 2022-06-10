package com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions;

public class QuantityNotAvailableException extends RuntimeException{

    public QuantityNotAvailableException(Long sectionId) {
        super("El sector con ID: " + sectionId + " no tiene espacio disponible para la cantidad de lotes de la entrega.");
    }

}