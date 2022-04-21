package com.example.deportistas.repositories;

import com.example.deportistas.model.Deporte;
import com.example.deportistas.model.Persona;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PersonaRepo {
    List<Persona> personas;
    public PersonaRepo(){
        personas = new ArrayList<>(List.of(
                new Persona("Tomas", "Ravelli", 24, List.of(new Deporte("Futbol", "Medio"),
                        new Deporte("Natacion", "Dificl"),
                        new Deporte("Tenis", "Medio"),
                        new Deporte("Boxeo", "Dificl"))),
                new Persona("Juan", "Perez", 24, List.of(new Deporte("Fubol", "Medio"),
                        new Deporte("Boxeo", "Dificl"))),
                new Persona("Tomas", "Ravelli", 24, List.of(new Deporte("Futbol", "Medio"),
                        new Deporte("Natacion", "Dificl"),
                        new Deporte("Tenis", "Medio"),
                        new Deporte("Boxeo", "Dificl"))),
                new Persona("Juan", "Perez", 24, List.of(new Deporte("Futbol", "Medio"),
                        new Deporte("Boxeo", "Dificl")))));
    }
    public void addPersona (Persona persona){
        personas.add(persona);
    }
    public void addAllPersonas(List<Persona> personas){
        this.personas.addAll(personas);
    }
}
