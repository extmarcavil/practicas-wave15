package com.example.demo.service;

import com.example.demo.dto.NivelDTO;
import com.example.demo.dto.PersonaDeporteDTO;
import com.example.demo.model.Deporte;
import com.example.demo.repository.IDeportistasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeportistasService implements IDeportistasService{

    IDeportistasRepository repository;

    public DeportistasService(IDeportistasRepository repository){
    this.repository = repository;
    }

    @Override
    public List<Deporte> getSports() {
        return repository.getSports();
    }

    @Override
    public NivelDTO getLevelBySport(String name){

        int nivel = repository.getLevel(name);

        if(nivel>= 0){
            return new NivelDTO(nivel);
        }

        return null;
    }

    @Override
    public List<PersonaDeporteDTO> getSportsPersons() {
        return repository.getPersons().stream().map(x-> new PersonaDeporteDTO(x.getNombre(),x.getApellido(),x.getDeporte().getNombre())).collect(Collectors.toList());
    }
}
