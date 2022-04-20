package com.company.model;

public class Cliente {
    private static int contador;
    private int idCliente;
    private String dni;
    private String nombre;
    private String apellido;

    public Cliente(String dni, String nombre, String apellido) {
        this.idCliente = ++this.contador;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "\n      - ID del Cliente : " + idCliente + "\n" +
                "      - DNI : '" + dni + '\'' + "\n" +
                "      - Nombre : '" + nombre + '\'' + "\n" +
                "      - Apellido : '" + apellido + '\'';
    }
}
