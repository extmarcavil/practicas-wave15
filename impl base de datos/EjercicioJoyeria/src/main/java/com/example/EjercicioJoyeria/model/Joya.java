package com.example.EjercicioJoyeria.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long nro_identificatorio;
    public String nombre;
    public String material;
    public String peso;
    public String particularidad;
    public boolean posee_piedra;
    public boolean ventaONo;
}


