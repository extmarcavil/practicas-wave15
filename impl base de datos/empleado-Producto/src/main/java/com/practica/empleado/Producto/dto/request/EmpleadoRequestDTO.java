package com.practica.empleado.Producto.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpleadoRequestDTO {

    private String nombre;
    private String apellido;
    private Integer edad;
    private String ciudad;

}
