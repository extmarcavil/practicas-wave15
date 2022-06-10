package com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions;

public class AgentDoesNotBelongToWarehouseException extends RuntimeException{

    public AgentDoesNotBelongToWarehouseException(Long agentId, Long warehouseCode) {
        super("El representante con ID: " + agentId + " no pertenece al almacen " + warehouseCode + ".");
    }

}
