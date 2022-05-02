package com.bootcamp.starWors.repository;

import com.bootcamp.starWors.dtos.PersonajeSWDTO;
import com.bootcamp.starWors.models.PersonajeSW;

import java.util.List;

public interface IDatosPersonajesRepository {

    List<PersonajeSW> findAllByNameContains(String name);


}
