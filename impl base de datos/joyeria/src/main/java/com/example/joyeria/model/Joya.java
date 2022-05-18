package com.example.joyeria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "joyas")
@Entity
public class Joya {

    /**
     * Atributos
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "nro_identidficatorio")
    private Long nroIdentificatorio;

    private String nombre;

    private String material;

    private Double peso;

    @Column(nullable = false, name = "posee_piedra")
    private Boolean poseePiedra;

    @Column(name = "en_venta")
    private Boolean ventaONo;
}
