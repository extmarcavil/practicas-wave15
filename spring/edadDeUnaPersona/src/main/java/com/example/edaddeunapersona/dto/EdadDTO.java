package com.example.edaddeunapersona.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EdadDTO {
    private int edad;

    public EdadDTO(int edad) {
        this.edad = edad;
    }
}
