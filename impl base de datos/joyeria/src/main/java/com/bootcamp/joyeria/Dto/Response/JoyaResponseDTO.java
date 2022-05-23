package com.bootcamp.joyeria.Dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoyaResponseDTO {
    private String nombre;
    private String material;
    private double peso;
    private String particularidad;
    private boolean posee_piedra;
}
