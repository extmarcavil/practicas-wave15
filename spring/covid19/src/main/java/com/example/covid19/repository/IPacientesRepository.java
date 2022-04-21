package com.example.covid19.repository;

import com.example.covid19.DTO.PacienteDTO;
import com.example.covid19.entities.Sintoma;

import java.util.List;
import java.util.Optional;

public interface IPacientesRepository {

     List<Sintoma> GetAllSintomas();

     Optional<Sintoma> getSintomaPorNombre(String nombre);

     List<PacienteDTO> getPersonas();
}
