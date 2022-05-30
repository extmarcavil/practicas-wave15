package com.meli.seguro.api.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class VehiclePatenteMarcaModeloDto implements Serializable {
    private final String patente;
    private final String marca;
    private final String modelo;
}
