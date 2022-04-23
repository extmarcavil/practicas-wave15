package com.edadpersona.CalculadoraEdades.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EdadDTO implements Serializable {
    Integer edad;

    public EdadDTO(Integer edad) {
        this.edad = edad;
    }
}
