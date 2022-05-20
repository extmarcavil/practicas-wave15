package com.example.empleados.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalidadRequestDTO {
    private String ciudad;
    private String provincia;
    private String estado;
    private String departamento;
}
