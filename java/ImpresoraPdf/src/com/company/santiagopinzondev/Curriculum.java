package com.company.santiagopinzondev;

import java.util.ArrayList;

public class Curriculum extends Documento {
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    ArrayList<String> habilidades;

    public Curriculum(String nombre, String apellido, String fechaNacimiento, ArrayList<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.habilidades = habilidades;
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ArrayList<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String mostrarTipoDocumento() {
        return "Curriculum";
    }

    @Override
    public String imprimirContenido() {
        return "Curriculum de " + nombre + " " + apellido + "\nFecha de Nacimiento: " + fechaNacimiento + "\n Habilidades: " + this.habilidades.toString();
    }
}
