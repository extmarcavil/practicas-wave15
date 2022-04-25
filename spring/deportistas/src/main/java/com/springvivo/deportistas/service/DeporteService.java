package com.springvivo.deportistas.service;

import com.springvivo.deportistas.dto.PersonaDTO;
import com.springvivo.deportistas.entity.Deporte;

import java.util.List;

public interface DeporteService {


     List<Deporte> getAllSports();

     String findSport(String nombre);

     List<PersonaDTO> getSportPeople();


}
