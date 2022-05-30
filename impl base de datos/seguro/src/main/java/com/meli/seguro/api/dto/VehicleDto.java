package com.meli.seguro.api.dto;

import com.meli.seguro.api.dto.AccidentOnlyDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter @Setter
public class VehicleDto implements Serializable {
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anioFabricacion;
    private Integer cantRuedas;
    private Set<AccidentOnlyDto> accidents;
}
