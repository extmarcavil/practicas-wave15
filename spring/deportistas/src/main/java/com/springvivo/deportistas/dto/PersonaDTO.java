package com.springvivo.deportistas.dto;


import java.io.Serializable;

public class PersonaDTO implements Serializable {

    private String nombre;
    private  String apellido;
    private String[] nombresDeporte;


    public PersonaDTO(String nombre, String apellido, String[] nombresDeporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombresDeporte = nombresDeporte;
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

    public String[] getNombresDeporte() {
        return nombresDeporte;
    }

    public void setNombresDeporte(String[] nombresDeporte) {
        this.nombresDeporte = nombresDeporte;
    }
}
