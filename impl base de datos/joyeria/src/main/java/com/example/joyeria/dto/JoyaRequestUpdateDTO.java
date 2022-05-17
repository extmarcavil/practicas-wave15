package com.example.joyeria.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class JoyaRequestUpdateDTO {

    private String nombre;

    private String material;

    @Min(value = 0, message = "El peso debe ser mayor a 0")
    private Double peso;

    private String particularidad;

    private Boolean posee_piedra;

}
