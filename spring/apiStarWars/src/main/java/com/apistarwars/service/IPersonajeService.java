package com.apistarwars.service;

import com.apistarwars.dto.PersonajeDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface IPersonajeService {
    List<PersonajeDTO> likeByNombre(String nombre);
}
