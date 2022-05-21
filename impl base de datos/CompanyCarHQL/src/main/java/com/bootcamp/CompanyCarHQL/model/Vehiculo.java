package com.bootcamp.CompanyCarHQL.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Vehiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String marca;
    private Integer year_of_production;
    private Integer amount_of_wheels;

    public Vehiculo(String patente, String marca, Integer year_of_production, Integer amount_of_wheels) {
        this.patente = patente;
        this.marca = marca;
        this.year_of_production = year_of_production;
        this.amount_of_wheels = amount_of_wheels;
    }

    public Vehiculo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getYear_of_production() {
        return year_of_production;
    }

    public void setYear_of_production(Integer year_of_production) {
        this.year_of_production = year_of_production;
    }

    public Integer getAmount_of_wheels() {
        return amount_of_wheels;
    }

    public void setAmount_of_wheels(Integer amount_of_wheels) {
        this.amount_of_wheels = amount_of_wheels;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "id=" + id +
                ", patente='" + patente + '\'' +
                ", marca='" + marca + '\'' +
                ", year_of_production=" + year_of_production +
                ", amount_of_wheels=" + amount_of_wheels +
                '}';
    }
}
