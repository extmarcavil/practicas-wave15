package com.example.edaddeunapersona.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class NacimientoDTO {
    private Integer dia;
    private Integer mes;
    private Integer anio;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    LocalDate fechaNacimiento;
}
