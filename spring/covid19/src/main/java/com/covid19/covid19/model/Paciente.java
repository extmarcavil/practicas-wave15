package com.covid19.covid19.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Paciente extends Persona{
    List<Sintoma> sintomaList;

    public Paciente(int id, String nombre, String apellido, int edad, List<Sintoma> sintomas) {
        super(id, nombre, apellido, edad);
        sintomaList = sintomas;
    }
}
