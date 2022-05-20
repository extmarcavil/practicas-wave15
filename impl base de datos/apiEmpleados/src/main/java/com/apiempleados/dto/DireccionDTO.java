package com.apiempleados.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DireccionDTO {
    private String ciudad;
    private String provincia;
    private String estado;
    private String departamento;
}
