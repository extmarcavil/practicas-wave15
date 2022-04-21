package com.Deportistas.Deportistas.Controller;
import com.Deportistas.Deportistas.PersonaDTO;
import com.Deportistas.Deportistas.model.Persona;
import com.Deportistas.Deportistas.model.Deporte;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeporteController {

    List<Deporte> deportes = new ArrayList<>();

    public void agregarDeportes() {
        deportes.add(new Deporte("natacion", 3));
        deportes.add(new Deporte("tennis", 2));
        deportes.add(new Deporte("futbol", 1));

    }

    @GetMapping("/findSports")
        public List<Deporte> showSports() {
        agregarDeportes();
        return deportes;
    }

    @GetMapping("/findSport/{name}")
    public Deporte sportById(@PathVariable String name) {
        agregarDeportes();
        Deporte dep = deportes.stream().filter(x->x.getNombre().equals(name)).findAny().orElse(null);
        return dep;
    }

    @GetMapping("/findSportsPersons")
    public PersonaDTO sportsAndPersons() {
        agregarDeportes();
        Deporte deporte = new Deporte("voley", 5);
        Persona persona = new Persona("Ana", "Paula", 23);
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setApellido(persona.getApellido());
        personaDTO.setNombrePersona(persona.getNombre());
        personaDTO.setNombreDeporte(deporte.getNombre());
        return personaDTO;
    }



}


