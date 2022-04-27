package com.meli.responseentity.persondto.service;

import com.meli.responseentity.persondto.dto.SportPersonDto;
import com.meli.responseentity.persondto.model.Sport;
import com.meli.responseentity.persondto.repository.PersonRepository;
import com.meli.responseentity.persondto.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SportService {

    private final SportRepository sportRepository;
    private final PersonRepository personRepository;

    @Autowired
    public SportService(SportRepository sportRepository, PersonRepository personRepository) {
        this.sportRepository = sportRepository;
        this.personRepository = personRepository;
    }

    @PostConstruct
    private void loadSomeSports() {
        personRepository.findAll().stream().limit(2)
                .forEach(person -> {
                    person.setSports(sportRepository.findWithLimit(2));
                    personRepository.update(person);
                });
    }

    public List<Sport> findAll() {
        return sportRepository.findAll();
    }

    public Sport findByName(String name) {
        return sportRepository.findByName(name);
    }

    public List<SportPersonDto> findSportPersons() {
        return personRepository.findAll().stream()
                .map(SportPersonDto::from)
                .collect(Collectors.toList());
    }
}
