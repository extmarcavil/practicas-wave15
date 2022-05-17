package com.example.joyeria.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter @Getter
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long nroIdentificatorio;
    private String nombre;
    private String material;
    private float peso;
    private String particularidad;
    private boolean poseePiedra;
    private boolean ventaONo;
}
