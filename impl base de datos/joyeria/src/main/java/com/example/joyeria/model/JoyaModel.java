package com.example.joyeria.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class JoyaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int nro_identificatorio;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;

    public JoyaModel(int nro_identificatorio, String nombre, String material, Double peso, String particularidad, boolean posee_piedra, boolean ventaONo) {
        this.nro_identificatorio = nro_identificatorio;
        this.nombre = nombre;
        this.material = material;
        this.peso = peso;
        this.particularidad = particularidad;
        this.posee_piedra = posee_piedra;
        this.ventaONo = ventaONo;
    }


    public JoyaModel(int nro_identificatorio) {
        this.nro_identificatorio = nro_identificatorio;
    }
}
