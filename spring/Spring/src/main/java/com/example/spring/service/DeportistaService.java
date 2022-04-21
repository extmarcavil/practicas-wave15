package com.example.spring.service;

import com.example.spring.dto.DeporteDTO;
import com.example.spring.dto.DeportistaDTO;
import com.example.spring.entity.DeporteEntity;
import com.example.spring.entity.DeportePersonaEntity;
import com.example.spring.entity.PersonaEntity;
import com.example.spring.repository.RespositoryAll;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeportistaService {

    RespositoryAll repository = new RespositoryAll();


    public List<DeporteEntity> findSports() {
        return repository.findAllSports();
    }

    public DeporteDTO findSport(String name) {
        DeporteEntity sport = repository.findSportByName(name);

        if (sport == null)
            return new DeporteDTO(-1);

        return new DeporteDTO(sport.getNivel());

    }

    public List<DeportistaDTO> findSportsPersons() {
        List<DeportistaDTO> deportistasDTO = new ArrayList<>();
        List<DeportePersonaEntity> deportesPersonas = repository.findSportsPersons();

        for (DeportePersonaEntity deportePersona : deportesPersonas) {
            DeportistaDTO deportistaDTO =
                    new DeportistaDTO(
                            deportePersona.getPersona().getNombre(),
                            deportePersona.getPersona().getApellido(),
                            deportePersona.getDeporte().getNombre());
            deportistasDTO.add(deportistaDTO);
        }

        return deportistasDTO;
    }

    public void saveSport(DeporteEntity sport) {
        repository.saveSport(sport);
    }

    public void savePerson(PersonaEntity person) {
        repository.savePersona(person);
    }

    public void saveSportPerson(String name, String sport) {
        DeportePersonaEntity deportePersonaEntity;
        PersonaEntity persona = repository.findPersonByName(name);
        DeporteEntity deporte = repository.findSportByName(sport);

        if (persona == null || deporte == null)
            return;

        deportePersonaEntity = new DeportePersonaEntity(persona, deporte);

        repository.saveSportPerson(deportePersonaEntity);
    }

    public List<PersonaEntity> findPersons() { return repository.findAllPersons(); }
}
