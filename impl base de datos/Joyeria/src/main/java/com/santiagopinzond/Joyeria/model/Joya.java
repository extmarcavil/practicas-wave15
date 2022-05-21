package com.santiagopinzond.Joyeria.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long nro_identificatorio;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;

    public Joya(String nombre, String material, Double peso, String particularidad, boolean posee_piedra, boolean ventaONo) {
        this.nombre = nombre;
        this.material = material;
        this.peso = peso;
        this.particularidad = particularidad;
        this.posee_piedra = posee_piedra;
        this.ventaONo = ventaONo;
    }

    public Joya() {
    }

    public Long getNro_identificatorio() {
        return nro_identificatorio;
    }

    public void setNro_identificatorio(Long nro_identificatorio) {
        this.nro_identificatorio = nro_identificatorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getParticularidad() {
        return particularidad;
    }

    public void setParticularidad(String particularidad) {
        this.particularidad = particularidad;
    }

    public boolean isPosee_piedra() {
        return posee_piedra;
    }

    public void setPosee_piedra(boolean posee_piedra) {
        this.posee_piedra = posee_piedra;
    }

    public boolean isVentaONo() {
        return ventaONo;
    }

    public void setVentaONo(boolean ventaONo) {
        this.ventaONo = ventaONo;
    }
}
