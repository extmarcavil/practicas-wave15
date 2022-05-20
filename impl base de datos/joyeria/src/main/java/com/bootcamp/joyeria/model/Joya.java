package com.bootcamp.joyeria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "joya")
public class Joya {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;

    private String material;

    private Double peso;

    private String particularidad;

    private String poseePiedra;

    private Boolean ventaONo;

}