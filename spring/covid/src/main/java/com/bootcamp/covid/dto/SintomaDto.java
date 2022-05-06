package com.bootcamp.covid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SintomaDto {

    /**
     * Atributos
     */
    String code;
    String name;
    String severityLevel;


}
