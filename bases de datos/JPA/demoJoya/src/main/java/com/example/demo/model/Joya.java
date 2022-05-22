package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long nro_identificatorio;
    private String nombre;
    private String material;
    private Long peso;
    private String particularidad;
    private Boolean posee_piedra;
    private Boolean ventaONo;

    public Joya() {
    }

    public Joya(Long nro_identificatorio, String nombre, String material, Long peso, String particularidad,
                Boolean posee_piedra, Boolean ventaONo) {
        this.nro_identificatorio = nro_identificatorio;
        this.nombre = nombre;
        this.material = material;
        this.peso = peso;
        this.particularidad = particularidad;
        this.posee_piedra = posee_piedra;
        this.ventaONo = ventaONo;
    }
}
