package com.example.covid19.services;

import com.example.covid19.DTO.PacienteDTO;
import com.example.covid19.entities.Sintoma;

import java.util.List;

public interface IPacientesService {

    List<Sintoma> getListadoSintomas();

    Sintoma getSintoma(String nombre);

    List<PacienteDTO> getListadoPacientesRiesgo();

}
