package com.practicas.deportistas.servicios;

import com.practicas.deportistas.dto.Deporte;
import com.practicas.deportistas.dto.Persona;

import java.util.ArrayList;
import java.util.List;

public class ServicioPersonas {
    public static List<Persona> buscarPersonas(){
        List<Persona> personas = new ArrayList<Persona>();
        List<Deporte> deportes = ServicioDeportes.buscarTodos();

        personas.add(new Persona("Luis", "Rodríguez", 25));
        personas.add(new Persona("David", "Benítez", 26));
        personas.add(new Persona("Alfredo", "Aguilar", 23));
        personas.add(new Persona("Ricardo", "Hernández", 24));
        personas.add(new Persona("Raúl", "Bautista", 27));

        personas.get(0).agregarDeporte(deportes.get(0));
        personas.get(1).agregarDeporte(deportes.get(1));
        personas.get(2).agregarDeporte(deportes.get(2));
        personas.get(3).agregarDeporte(deportes.get(3));
        personas.get(4).agregarDeporte(deportes.get(4));

        return personas;
    }
}
