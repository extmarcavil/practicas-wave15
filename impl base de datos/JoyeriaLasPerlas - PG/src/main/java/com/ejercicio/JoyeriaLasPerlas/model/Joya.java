package com.ejercicio.JoyeriaLasPerlas.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long nro_identificatorio;
    private String nombre;
    private String material;
    private Double pesoEnGramos;
    private String particularidad;
    private boolean posee_piedra = true;
    private boolean ventaONo;


    public Joya(String nombre, String material, Double pesoEnGramos, String particularidad, boolean ventaONo) {
        this.nombre = nombre;
        this.material = material;
        this.pesoEnGramos = pesoEnGramos;
        this.particularidad = particularidad;
        this.ventaONo = ventaONo;
    }
}
