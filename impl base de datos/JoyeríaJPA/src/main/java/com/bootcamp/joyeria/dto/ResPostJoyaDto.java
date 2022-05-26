package com.bootcamp.joyeria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResPostJoyaDto {

    private Long nro_identificatorio;
    private String name;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean posee_piedra;
    private Boolean venta_o_no;
}
