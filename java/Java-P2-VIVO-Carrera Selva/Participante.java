package com.company;

public class Participante {
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String nroEmergencia;
    private String grupoSanguineo;

    public Participante(){

    }

    public Participante(String dni, String nombre, String apellido, int edad, String celular, String nroEmergencia, String grupoSanguineo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.nroEmergencia = nroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNroEmergencia() {
        return nroEmergencia;
    }

    public void setNroEmergencia(String nroEmergencia) {
        this.nroEmergencia = nroEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    @Override
    public String toString() {
        return "Datos del Participante:" +
                " Dni = '" + dni + '\'' +
                ", nombre = '" + nombre + '\'' +
                ", apellido = '" + apellido + '\'' +
                ", edad = " + edad +
                ", celular = '" + celular + '\'' +
                ", nroEmergencia = '" + nroEmergencia + '\'' +
                ", grupoSanguineo = '" + grupoSanguineo + '\'' +
                '}';
    }
}
