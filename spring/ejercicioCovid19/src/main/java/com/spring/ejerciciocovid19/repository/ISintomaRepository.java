package com.spring.ejerciciocovid19.repository;

import com.spring.ejerciciocovid19.dtos.SintomaDTO;

import java.util.List;
import java.util.Optional;

public interface ISintomaRepository {
    List<SintomaDTO> getAllSintomas();
    Optional<SintomaDTO> getSintomaByName(String name);

}
