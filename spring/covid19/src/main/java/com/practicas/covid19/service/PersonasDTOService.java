package com.practicas.covid19.service;

import com.practicas.covid19.dto.PersonaDTO;
import com.practicas.covid19.model.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonasDTOService {
    public static List<PersonaDTO> getPersonasDTO() {
        List<PersonaDTO> dto = new ArrayList<PersonaDTO>();
        for (Persona persona: PersonasService.buscarPersonas()
                .stream()
                .filter(persona -> persona.getEdad()>60)
                .filter(persona -> persona.getSintomas().size()>0)
                .collect(Collectors.toList())) {
            PersonaDTO personaTemp= new PersonaDTO();
            personaTemp.setNombre(persona.getNombre());
            personaTemp.setApellido(persona.getApellido());
            personaTemp.setEdad(persona.getEdad()+"");
            personaTemp.setSintomas(persona.getSintomas().stream()
                    .map(sintoma -> sintoma.getNombre()).collect(Collectors.toList())
                    .toString());
            dto.add(personaTemp);
        }
        return dto;
    }
}
