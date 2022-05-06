package com.company.model;

public class Cliente {

    /**
     * Atributos
     */
    private int dni;
    private String nombre;
    private String apellido;


    /**
     * Constructor
     *
     * @param dni
     * @param nombre
     * @param apellido
     */
    public Cliente(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }


    /**
     * ToString()
     */
    @Override
    public String toString() {
        return "Cliente{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

    /**
     * Getter && Setter
     */
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
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
}
