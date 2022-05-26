package com.bootcamp.joyeria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long nro_identificatorio;
    private String name;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean posee_piedra;
    private Boolean venta_o_no;

    public Joya(String name, String material, Double peso, String particularidad, Boolean posee_piedra, Boolean venta_o_no) {
        this.name = name;
        this.material = material;
        this.peso = peso;
        this.particularidad = particularidad;
        this.posee_piedra = posee_piedra;
        this.venta_o_no = venta_o_no;
    }
}
