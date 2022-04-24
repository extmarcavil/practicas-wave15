package com.springvivo.edad.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EdadDTO {
    private Integer edad;

    public EdadDTO(Integer edad) {
        this.edad = edad;
    }
}
