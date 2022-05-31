package com.example.deportistasapi.service;

import com.example.deportistasapi.model.Deporte;
import com.example.deportistasapi.model.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService implements IPersonaService {
    private DeporteService deporteService = new DeporteService();

    private List<Persona> personas = new ArrayList<>();

    public PersonaService() {
        List<Deporte> deportes = this.deporteService.findAllSports();

        Persona persona1 = new Persona();
        persona1.setNombre("Lionel");
        persona1.setApellido("Messi");
        persona1.setEdad(34);
        persona1.addDeporte(deportes.get(0));

        Persona persona2 = new Persona();
        persona2.setNombre("Hisashi");
        persona2.setApellido("Mitsui");
        persona2.setEdad(17);
        persona2.addDeporte(deportes.get(1));

        Persona persona3 = new Persona();
        persona3.setNombre("Roger");
        persona3.setApellido("Federer");
        persona3.setEdad(40);
        persona3.addDeporte(deportes.get(2));
        persona3.addDeporte(deportes.get(3));

        Persona persona4 = new Persona();
        persona4.setNombre("Keanu");
        persona4.setApellido("Reeves");
        persona4.setEdad(57);

        this.personas.add(persona1);
        this.personas.add(persona2);
        this.personas.add(persona3);
    }

    public List<Persona> findSportsPersons() {
        return this.personas
                .stream()
                .filter(p -> p.getDeportes().size() > 0)
                .collect(Collectors.toList());
    }
}
