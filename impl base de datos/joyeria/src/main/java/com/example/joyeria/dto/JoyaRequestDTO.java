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
public class JoyaRequestDTO {

    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;

    @NotBlank(message = "El material no puede estar vacio")
    private String material;

    @NotNull(message = "El peso no puede estar vacio")
    @Min(value = 0, message = "El peso debe ser mayor a 0")
    private Double peso;

    private String particularidad;

    @NotNull(message = "posee_piedra no puede estar vacio")
    private Boolean posee_piedra;


    @NotNull(message = "ventaONo no puede estar vacio")
    private Boolean ventaONo;
}
