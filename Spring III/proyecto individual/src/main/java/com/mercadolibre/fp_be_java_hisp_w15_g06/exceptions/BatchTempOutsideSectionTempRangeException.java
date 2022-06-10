package com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions;

public class BatchTempOutsideSectionTempRangeException extends RuntimeException{

    public BatchTempOutsideSectionTempRangeException(Long productId, Double tempMin, Double tempMax) {
        super("Las temperaturas del lote con Id de producto " + productId + " deben estar dentro del rango de temperaturas del sector ("+tempMin+"º a " + tempMax + "º)");
    }

}