package com.example.demo.DTO;

import lombok.Data;

@Data
public class JoyaRespDTO {
    private Long nro_identificatorio;
    private String nombre;
    private String material;
    private Long peso;
    private String particularidad;
    private Boolean posee_piedra;
    private Boolean ventaONo;

    public JoyaRespDTO() {
    }
}
