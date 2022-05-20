package com.apiempleados.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDTO {
    private String id;
    private String nombre;
    private String apellido;
    private int edad;

    private DireccionDTO direccion;
}
