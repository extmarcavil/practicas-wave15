package com.bootcamp.deportistas.service;

import com.bootcamp.deportistas.dto.PersonDTO;
import com.bootcamp.deportistas.dto.SportDTO;
import com.bootcamp.deportistas.model.Sport;
import com.bootcamp.deportistas.repository.ISportRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SportService implements ISportService {

    ISportRepository repository;
    ModelMapper mapper = new ModelMapper();

    public SportService() {
    }

    public SportService(ISportRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SportDTO> getSports() {
        return repository.getAllSports().stream().map(sport -> mapper.map(sport, SportDTO.class)).collect(Collectors.toList());
    }

    @Override
    public SportDTO getSport(String name) {

        Sport sport = repository.getSportByName(name).orElseThrow(() -> new RuntimeException("No se encontró el deporte"));
        SportDTO temp = mapper.map(sport, SportDTO.class);
        return temp;

    }

    @Override
    public List<PersonDTO> getPeople() {
        List<PersonDTO> people = repository.getPeople().stream().map(person -> mapper.map(person, PersonDTO.class)).collect(Collectors.toList());
        return people;
    }
}
