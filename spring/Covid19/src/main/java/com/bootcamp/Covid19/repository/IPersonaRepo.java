package com.bootcamp.Covid19.repository;

import com.bootcamp.Covid19.model.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonaRepo {
    List<Persona> getRiskPeople();
}

