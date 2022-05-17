package com.crud.joyeria.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private int nro_identificatorio;
    private String nombre;
    private String material;
    private Double  peso;
    private String particularidad;
    private Boolean poseePiedra;
    private Boolean ventaONo;


}
