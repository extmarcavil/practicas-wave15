package com.bootcamp.CompanyCarHQL.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Siniestro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateSiniestro;
    private Double perdidaEconomica;
    private Long idVehiculoDenunciado;

    public Siniestro(LocalDate dateSiniestro, Double perdidaEconomica, Long idVehiculoDenunciado) {
        this.dateSiniestro = dateSiniestro;
        this.perdidaEconomica = perdidaEconomica;
        this.idVehiculoDenunciado = idVehiculoDenunciado;
    }

    public Siniestro() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateSiniestro() {
        return dateSiniestro;
    }

    public void setDateSiniestro(LocalDate dateSiniestro) {
        this.dateSiniestro = dateSiniestro;
    }

    public Double getPerdidaEconomica() {
        return perdidaEconomica;
    }

    public void setPerdidaEconomica(Double perdidaEconomica) {
        this.perdidaEconomica = perdidaEconomica;
    }

    public Long getIdVehiculoDenunciado() {
        return idVehiculoDenunciado;
    }

    public void setIdVehiculoDenunciado(Long idVehiculoDenunciado) {
        this.idVehiculoDenunciado = idVehiculoDenunciado;
    }
}
