package com.example.segurosautos.dto;

import com.example.segurosautos.model.Vehiculo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SiniestroDTO {
    private Integer id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fecha;

    private Double perdidaEconomica;

    private VehiculoDTO vehiculo;
}
