package com.example.segurosautos.dto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VehiculoDTO {
    private Integer id;

    private String patente;

    private String marca;

    private String modelo;

    private Integer anioFabricacion;

    private Integer cantRuedas;

    private List<SiniestroDTO> siniestros;

}
