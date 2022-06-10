package com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions;

public class InvalidSectionbatchException extends RuntimeException {

    public InvalidSectionbatchException(Long idSection) {
        super("No existen batch asociado/s a la sección con ID: " + idSection);
    }
}
