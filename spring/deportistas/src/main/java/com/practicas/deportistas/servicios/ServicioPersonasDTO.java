package com.practicas.deportistas.servicios;

import com.practicas.deportistas.dto.Persona;
import com.practicas.deportistas.dto.PersonaDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServicioPersonasDTO {
    public static List<PersonaDTO> getPersonasDTO() {
        List<PersonaDTO> dto = new ArrayList<PersonaDTO>();
        for (Persona persona:ServicioPersonas.buscarPersonas()) {
            PersonaDTO personaTemp= new PersonaDTO();
            personaTemp.setFullName(persona.getNombre()+" "+persona.getApellido());
            personaTemp.setDeporte(persona.getDeportes().stream()
                    .map(deporte -> deporte.getNombre()).collect(Collectors.toList())
                    .toString());
            dto.add(personaTemp);
        }
        return dto;
    }
}
