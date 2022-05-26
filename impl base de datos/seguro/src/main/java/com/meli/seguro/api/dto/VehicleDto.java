package com.meli.seguro.api.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class VehicleDto implements Serializable {
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anioFabricacion;
    private Integer cantRuedas;
}
