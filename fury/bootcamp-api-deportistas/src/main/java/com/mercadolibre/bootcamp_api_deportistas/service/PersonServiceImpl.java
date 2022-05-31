package com.mercadolibre.bootcamp_api_deportistas.service;

import com.mercadolibre.bootcamp_api_deportistas.dtos.PersonDTO;
import com.mercadolibre.bootcamp_api_deportistas.entity.Person;
import com.mercadolibre.bootcamp_api_deportistas.entity.Sport;
import com.mercadolibre.bootcamp_api_deportistas.repository.PersonRepository;
import com.mercadolibre.bootcamp_api_deportistas.repository.SportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{
    private final PersonRepository personRepository;
    private final SportRepository sportRepository;

    @Override
    public List<PersonDTO> findSportsPersons() {
        List<PersonDTO> persons = new ArrayList<>();
        for (Person person : personRepository.getPersons()) {
            Sport sport = sportRepository.getSport(person.getSportName());
            persons.add(new PersonDTO(person, sport));
        }
        return persons;
    }
}
