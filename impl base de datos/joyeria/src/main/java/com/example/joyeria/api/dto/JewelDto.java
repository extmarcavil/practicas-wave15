package com.example.joyeria.api.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class JewelDto implements Serializable {
    private final String nombre;
    private final String material;
    private final Integer gramos;
    private final String particularidad;
    private final Boolean poseePiedra;
    private final Boolean enVenta;
}
