package com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions;

public class InvalidSectionException extends RuntimeException{

    public InvalidSectionException(Long sectionId) {
        super("El sector con ID: " + sectionId + " no fue encontrado.");
    }

}
