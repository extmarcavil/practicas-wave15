package com.starwars.starwars.servicio;

import com.starwars.starwars.dto.PersonajeDTO;
import java.util.List;

public interface PersonajeServicio {
    public List<PersonajeDTO> getPersonajesPorNombre(String nombre);
}
