package com.example.crudjoyeria.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter @Setter @Entity
public class Joya {
    @Id
    @GeneratedValue
    Long id;

    String nombre;
    String material;
    int peso;
    String particularidad;
    boolean poseePiedra;
    boolean ventaONo;
}
