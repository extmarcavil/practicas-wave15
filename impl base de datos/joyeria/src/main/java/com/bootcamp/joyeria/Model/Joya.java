package com.bootcamp.joyeria.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long nro_identificatorio;
    private String nombre;
    private String material;
    private double peso;
    private String particularidad;
    private boolean posee_piedra;
    @Column(name = "ventaONo")
    private boolean ventaONo = true;


}
