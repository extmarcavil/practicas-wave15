package com.example.edadpersona.repository;

import com.example.edadpersona.model.Deporte;
import com.example.edadpersona.model.Persona;
import com.example.edadpersona.dtos.PersonaDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonasRepository {
    static List<Persona> personas = new ArrayList<>();
    static{
        List<Deporte> deportes = new ArrayList<>();
        deportes.add(new Deporte("Futbol", "Dificil"));
        deportes.add(new Deporte("Natacion", "Dificil"));
        personas.add(new Persona("Pedro","Rodriguez", 30L, deportes));
        List<Deporte> deportes1 = new ArrayList<>();
        deportes1.add(new Deporte("Futbol", "Medio"));
        deportes1.add(new Deporte("Boxeo", "Dificil"));
        personas.add(new Persona("Diego","Perez", 40L, deportes1));
        personas.add(new Persona("Dario","Fernandez", 20L, new ArrayList<>()));
        personas.add(new Persona("Juan","Dominguez", 24L, new ArrayList<>()));
    }

    public static List<PersonaDTO> getPersonasDeportistas(){
        List<PersonaDTO> deportistasDto = new ArrayList<>();
        List<Persona> deportistas = personas.stream().filter(p -> p.getDeportes().size() >= 1).collect(Collectors.toList());

        for (Persona deportista : deportistas) {
            List<String> deportes = new ArrayList<>();
            for(Deporte dep : deportista.getDeportes()){
                deportes.add(dep.getNombre());
            }
            deportistasDto.add(new PersonaDTO(deportista.getNombre(), deportista.getApellido(), deportes));
        }

        return deportistasDto;
    }
}
