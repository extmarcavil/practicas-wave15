package com.bootcamp.deportistas.service;

import com.bootcamp.deportistas.dto.DeporteDTO;
import com.bootcamp.deportistas.dto.PersonaDTO;
import com.bootcamp.deportistas.repository.DeportistaRepository;
import com.bootcamp.deportistas.repository.IDeportistaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeportistaService implements IDeportistaService {
    IDeportistaRepository rep;

    public DeportistaService(IDeportistaRepository rep) {
        this.rep = rep;
    }

    @Override
    public DeporteDTO getSportDTO(String sportName){
        return rep.getSportByName(sportName);
    }

    @Override
    public List<PersonaDTO> getSportsPersons(){
        return rep.getSportsPersons();
    }

    @Override
    public List<DeporteDTO> getSports(){
        return rep.getSports();
    }
}
