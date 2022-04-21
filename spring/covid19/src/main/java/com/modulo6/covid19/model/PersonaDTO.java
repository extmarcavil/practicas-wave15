package com.modulo6.covid19.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {

    private Long _id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private List<SintomaDTO> sintomas;

    @JsonIgnore
    public boolean esMayor () {
        return edad >= 60;
    }

//    public PersonaDTO() {
//    }
//
//    public PersonaDTO(String _id, String nombre, String apellido, Integer edad) {
//        this._id = _id;
//        this.nombre = nombre;
//        this.apellido = apellido;
//        this.edad = edad;
//    }
//
//    public String get_id() {
//        return _id;
//    }
//
//    public void set_id(String _id) {
//        this._id = _id;
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
//    public String getApellido() {
//        return apellido;
//    }
//
//    public void setApellido(String apellido) {
//        this.apellido = apellido;
//    }
//
//    public Integer getEdad() {
//        return edad;
//    }
//
//    public void setEdad(Integer edad) {
//        this.edad = edad;
//    }
//
//
//    @Override
//    public String toString() {
//        return "Persona{" +
//                "_id='" + _id + '\'' +
//                ", nombre='" + nombre + '\'' +
//                ", apellido='" + apellido + '\'' +
//                ", edad=" + edad +
//                '}';
//    }
}
