package com.example.CrudConJPAJoyeriaLasPerlas.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Integer nro_identificatorio;
    private String nombre;
    private String material;
    private int peso;
    private String particularidad;
    private boolean posePiedra;
    private boolean ventaONo;

    public Joya(String nombre, String material, int peso, String particularidad, boolean posePiedra, boolean ventaONo) {
        this.nombre = nombre;
        this.material = material;
        this.peso = peso;
        this.particularidad = particularidad;
        this.posePiedra = posePiedra;
        this.ventaONo = ventaONo;
    }

    public Joya() {

    }
}
