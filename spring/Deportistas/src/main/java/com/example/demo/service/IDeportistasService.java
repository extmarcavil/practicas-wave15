package com.example.demo.service;


import com.example.demo.dto.NivelDTO;
import com.example.demo.dto.PersonaDeporteDTO;
import com.example.demo.model.Deporte;

import java.util.List;

public interface IDeportistasService {
    List<Deporte> getSports();
    NivelDTO getLevelBySport(String name);
    List<PersonaDeporteDTO> getSportsPersons();
}
