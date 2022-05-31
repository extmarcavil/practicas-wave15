package com.example.deportistasapi.service;

import com.example.deportistasapi.model.Deporte;

import java.util.List;
import java.util.Optional;

public interface IDeporteService {

    List<Deporte> findAllSports();
    Optional<Deporte> findSportByName(String name);
}
