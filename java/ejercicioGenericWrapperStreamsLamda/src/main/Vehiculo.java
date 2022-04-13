package main;

import java.util.stream.DoubleStream;

public class Vehiculo {
    private String marca;
    private String modelo;
    private Float costo;

    public Vehiculo(String marca, String modelo, Float costo) {
        this.marca = marca;
        this.modelo = modelo;
        this.costo = costo;
    }

    public Vehiculo(){

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return marca+"-"+modelo+"-"+costo;
    }
}
