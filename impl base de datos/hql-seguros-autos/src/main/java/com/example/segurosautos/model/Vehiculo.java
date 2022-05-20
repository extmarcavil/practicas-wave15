package com.example.segurosautos.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String patente;

    private String marca;

    private String modelo;

    @Column(name = "anio_fabricacion")
    private Integer anioFabricacion;

    @Column(name = "cantidad_ruedas")
    private Integer cantRuedas;

    @OneToMany(mappedBy = "vehiculo")
    private List<Siniestro> siniestros;

}
