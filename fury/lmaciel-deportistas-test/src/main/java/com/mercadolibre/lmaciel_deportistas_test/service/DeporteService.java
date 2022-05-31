package com.mercadolibre.lmaciel_deportistas_test.service;


import com.mercadolibre.lmaciel_deportistas_test.dtos.PersonaDTO;
import com.mercadolibre.lmaciel_deportistas_test.entity.Deporte;

import java.util.List;

public interface DeporteService {


     List<Deporte> getAllSports();

     String findSport(String nombre);

     List<PersonaDTO> getSportPeople();


}
