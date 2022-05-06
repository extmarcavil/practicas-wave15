package com.bootcamp.covid.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PacienteDto {

    /**
     * Atributos
     */
    String name;
    String lastname;
    List<SintomaDto> symptoms;

}
