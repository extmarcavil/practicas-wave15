package com.example.joyeria.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "jewel")
@Data
public class Jewel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jewel_seq")
    @SequenceGenerator(name = "jewel_seq")
    @Column(name = "id_jewel", nullable = false)
    private Long idJewel;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "material", length = 50)
    private String material;

    @Column(name = "gramos")
    private Integer gramos;

    @Column(name = "particularidad")
    private String particularidad;

    @Column(name = "posee_piedra")
    private Boolean poseePiedra;

    @Column(name = "en_venta")
    private Boolean enVenta;

}