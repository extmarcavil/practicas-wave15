package com.example.deportistas.repositories;

import com.example.deportistas.model.Deporte;
import com.example.deportistas.model.Persona;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Repository
public class PersonaRepo implements IPersonaRepo{
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

    @Override
    public void addPersona (Persona persona){
        personas.add(persona);
    }

    @Override
    public void addAllPersonas(List<Persona> personas){
        this.personas.addAll(personas);
    }

    @Override
    public List<Persona> getPersonas(){
        return this.personas;
    }


}
