package com.modulo6.covid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SintomaDTO {

    private Long codigo;
    private String nombre;
    private String nivelDeGavedad;



//    public SintomaDTO() {
//    }
//
//    public SintomaDTO(String codigo, String nombre, String nivelDeGavedad) {
//        this.codigo = codigo;
//        this.nombre = nombre;
//        this.nivelDeGavedad = nivelDeGavedad;
//    }
//
//    public String getCodigo() {
//        return codigo;
//    }
//
//    public void setCodigo(String codigo) {
//        this.codigo = codigo;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public String getNivelDeGavedad() {
//        return nivelDeGavedad;
//    }
//
//    public void setNivelDeGavedad(String nivelDeGavedad) {
//        this.nivelDeGavedad = nivelDeGavedad;
//    }
//
//    @Override
//    public String toString() {
//        return "Sintoma{" +
//                "codigo='" + codigo + '\'' +
//                ", nombre='" + nombre + '\'' +
//                ", nivelDeGavedad='" + nivelDeGavedad + '\'' +
//                '}';
//    }
}
