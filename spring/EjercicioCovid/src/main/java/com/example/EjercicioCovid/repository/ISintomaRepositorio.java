package com.example.EjercicioCovid.repository;

import com.example.EjercicioCovid.dto.PacienteDTO;
import com.example.EjercicioCovid.dto.PersonaDTO;
import com.example.EjercicioCovid.dto.SintomaDTO;

import java.util.ArrayList;
import java.util.List;

public interface ISintomaRepositorio {

    public ArrayList<SintomaDTO> obtenerSintomas();

    public SintomaDTO obtenerSintomaxNombre(String nombre);

    public List<PersonaDTO> ObtenerPacientesRiesgo();
}
