package com.example.EjercicioCovid.service;

import com.example.EjercicioCovid.dto.PacienteDTO;
import com.example.EjercicioCovid.dto.PersonaDTO;
import com.example.EjercicioCovid.dto.SintomaDTO;
import com.example.EjercicioCovid.repository.ISintomaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SintomaServicio {
    ISintomaRepositorio repository;

    List<SintomaDTO> sintomas;

    List<PersonaDTO> persona;

    public SintomaServicio(ISintomaRepositorio repository){
        sintomas = new ArrayList<>();
        persona = new ArrayList<>();
        this.repository = repository;
    }

    public List<SintomaDTO> getSintomas(){
        return sintomas;
    }

    public ArrayList<SintomaDTO> getSintomasDTO(){
        ArrayList<SintomaDTO> listaSintomasDTO = repository.obtenerSintomas();
        return listaSintomasDTO;
    }

    public SintomaDTO getSintomaByName(String name){
        SintomaDTO sintomaDTO = repository.obtenerSintomaxNombre(name);
        return sintomaDTO;
    }

    public List<PacienteDTO> getPacientesRiesgo(){
        List<PacienteDTO> listaPacientesRiesgo = repository.ObtenerPacientesRiesgo()
                .stream()
                .map(personasRiesgo -> new PacienteDTO(personasRiesgo.getNombre(), personasRiesgo.getApellido(), personasRiesgo.getListaSintomas()))
                .collect(Collectors.toList());
        return listaPacientesRiesgo;
    }

}
