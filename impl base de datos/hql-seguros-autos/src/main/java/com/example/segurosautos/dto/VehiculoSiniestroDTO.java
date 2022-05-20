package com.example.segurosautos.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VehiculoSiniestroDTO {
    private List<VehiculoPatenteYMarcaYModeloDTO> vehiculoDTO;
    private Double costoTotal;
}
