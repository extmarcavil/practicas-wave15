package com.example.deportistas.services.person;

import com.example.deportistas.model.Deporte;
import com.example.deportistas.model.Persona;
import com.example.deportistas.repositories.PersonaRepo;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    PersonaRepo personaRepo = new PersonaRepo();

    @Override
    public void addPersona(Persona persona) {
        personaRepo.addPersona(persona);
    }

    @Override
    public void addAllPersonas(List<Persona> personas) {
        personaRepo.addAllPersonas(personas);
    }

    @Override
    public void addDeporte(Persona p, Deporte d) {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < personaRepo.getPersonas().size(); i++) {
            if(p.getNombre().equals(personaRepo.getPersonas().get(i).getNombre()) && p.getApellido().equals(personaRepo.getPersonas().get(i).getApellido())){
                indices.add(i);
            }
        }
        for (Integer i: indices) {
            personaRepo.getPersonas().get(i).getDeporteList().add(d);
        }
    }

    @Override
    public void addAllDeportes(Persona p, List<Deporte> deporteList) {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < personaRepo.getPersonas().size(); i++) {
            if(p.getNombre().equals(personaRepo.getPersonas().get(i).getNombre()) && p.getApellido().equals(personaRepo.getPersonas().get(i).getApellido())){
                indices.add(i);
            }
        }
        for (Integer i: indices) {
            personaRepo.getPersonas().get(i).getDeporteList().addAll(deporteList);
        }
    }

    @Override
    public List<Persona> findAll() {
        return personaRepo.getPersonas();
    }
}
