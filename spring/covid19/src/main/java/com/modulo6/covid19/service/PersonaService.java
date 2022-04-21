package com.modulo6.covid19.service;

import com.modulo6.covid19.model.PacienteDTO;

import java.util.List;

public interface PersonaService {

    List<PacienteDTO> getPacientesMayores();
}
