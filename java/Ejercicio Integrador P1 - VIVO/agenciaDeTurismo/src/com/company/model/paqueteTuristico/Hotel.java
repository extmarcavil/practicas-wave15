package com.company.model.paqueteTuristico;

import com.company.model.Cliente;

public class Hotel extends Reserva{
    private String nombre;
    private String direccion;

    public Hotel(Cliente cliente, double monto, String nombre, String direccion) {
        super(cliente, monto);
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "\n      * Datos del Hotel: " + "\n" +
                "           - Nombre del Hotel: '" + nombre + '\'' + "\n" +
                "           - direccion del Hotel: '" + direccion + '\'';
    }
}
