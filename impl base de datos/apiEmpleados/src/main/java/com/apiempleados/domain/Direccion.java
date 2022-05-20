package com.apiempleados.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Direccion {
    private String ciudad;
    private String provincia;
    private String estado;
    private String departamento;
}
