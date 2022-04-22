package com.practicas.covid19.service;

import com.practicas.covid19.model.Persona;
import com.practicas.covid19.model.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class PersonasService {

    public static List<Persona> buscarPersonas() {
        List<Persona> personas = new ArrayList<Persona>();
        List<Sintoma> sintomas = SintomasService.obtenerSintomas();

        personas.add(new Persona(1, "Luis", "Rodríguez", 25));
        personas.add(new Persona(2, "David", "Benítez", 61));
        personas.add(new Persona(3, "Alfredo", "Aguilar", 30));
        personas.add(new Persona(4, "Ricardo", "Hernández", 74));
        personas.add(new Persona(5, "Raúl", "Bautista", 65));

        personas.get(0).agregarSintoma(sintomas.get(0));
        personas.get(0).agregarSintoma(sintomas.get(2));
        personas.get(1).agregarSintoma(sintomas.get(1));
        personas.get(1).agregarSintoma(sintomas.get(3));
        personas.get(2).agregarSintoma(sintomas.get(2));
        personas.get(2).agregarSintoma(sintomas.get(1));
        personas.get(4).agregarSintoma(sintomas.get(6));
        personas.get(4).agregarSintoma(sintomas.get(7));
        personas.get(4).agregarSintoma(sintomas.get(4));

        return personas;

    }
}
