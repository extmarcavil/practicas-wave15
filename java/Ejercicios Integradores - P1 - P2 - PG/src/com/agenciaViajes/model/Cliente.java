package com.agenciaViajes.model;


public class Cliente {
    private String nombre;
    private String dni;
    private boolean descuentoAcumulado;

    public Cliente() {
    }

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public boolean isDescuentoAcumulado() {
        return descuentoAcumulado;
    }

    public void setDescuentoAcumulado(boolean descuentoAcumulado) {
        this.descuentoAcumulado = descuentoAcumulado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni +
                '}';
    }
}
