package com.example.spring.dto;

public class DeportistaDTO {

    private String nombre;
    private String apellido;
    private String deporte;


    public DeportistaDTO(String nombre, String apellido, String deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.deporte = deporte;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDeporte() {
        return deporte;
    }
}
