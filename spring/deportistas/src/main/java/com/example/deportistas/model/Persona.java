package com.example.deportistas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Persona {
    private String nombre;
    private String apellido;
    private Integer edad;
    private List<Deporte> deporteList;
}
