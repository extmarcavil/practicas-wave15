package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NivelDTO {

    int nivel;

    public NivelDTO(int nivel) {
        this.nivel = nivel;
    }
}
