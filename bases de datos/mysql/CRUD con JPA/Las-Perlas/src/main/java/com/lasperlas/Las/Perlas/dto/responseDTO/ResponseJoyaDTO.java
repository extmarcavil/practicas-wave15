package com.lasperlas.Las.Perlas.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseJoyaDTO {
    private Long nro_identificatorio;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;
    private String mensaje;

    public ResponseJoyaDTO() {
    }
}
