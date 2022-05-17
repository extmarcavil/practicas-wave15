package com.bootcamp.joyeriaLasPerlas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long nro_identificatorio;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;

    public Joya(Long id, String nombre, String material, Double peso, String particularidad, boolean posee_piedra, boolean ventaONo) {
        this.nro_identificatorio = id;
        this.nombre = nombre;
        this.material = material;
        this.peso = peso;
        this.particularidad = particularidad;
        this.posee_piedra = posee_piedra;
        this.ventaONo = ventaONo;
    }

    public Joya() {
    }
}
