package com.joyas.ejerciciojoyas.dto.response;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class JoyaResponseDTO {
    private Long nro_identificatorio;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean posee_piedras;
    private Boolean ventaono;
}
