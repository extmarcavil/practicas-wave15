package com.example.relaciones.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "person")
@IdClass(PersonKey.class)
@Getter @Setter
public class Person {
    @Id
    @Column(name = "nro_dni",nullable = false)
    private Integer nroDni;
    @Id
    @Column(name = "nro_tramite",nullable = false)
    private Integer nroTramite;

    private String nombre;


}