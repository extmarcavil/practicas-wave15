package com.example.hqlejerciciopractico.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String marca;
    private String Modelo;
    private LocalDate dateMaking;
    private int wheelQuantity;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private Set<Siniestro> siniestros;
}
