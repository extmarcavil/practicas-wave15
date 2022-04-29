package com.arqmulticapa.starwars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PersonajeDTO {
    private String name;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
}
