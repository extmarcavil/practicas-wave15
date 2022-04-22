package com.example.covid19.services;

import com.example.covid19.DTO.PacienteDTO;
import com.example.covid19.entities.Sintoma;
import com.example.covid19.repository.PacientesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacientesService implements IPacientesService {

    PacientesRepository repository;

    public PacientesService(PacientesRepository pacientesRepository) {
        this.repository = pacientesRepository;
    }

    @Override
    public List<Sintoma> getListadoSintomas(){
        return repository.GetAll Sintomas();
    }

    @Override
    public  Sintoma getSintoma(String nombre) {
        return repository.getSintomaPorNombre(nombre).orElse(null);
    }

    @Override
    public List<PacienteDTO> getListadoPacientesRiesgo(){
        return repository.getPersonas();
    }

}
