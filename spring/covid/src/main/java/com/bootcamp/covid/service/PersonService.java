package com.bootcamp.covid.service;

import com.bootcamp.covid.dto.PersonDTO;

import com.bootcamp.covid.model.Person;
import com.bootcamp.covid.repository.PersonRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.bootcamp.covid.repository.PersonRepository.listPerson;
@Service
public class PersonService {
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public List<PersonDTO> findRiskPerson(){
        List<Person> persons = personRepository.getRiskPerson();
        List<PersonDTO> personDTO = new ArrayList<>();
        for (Person person : persons) {
            personDTO.add(new PersonDTO(person));
        }
        return personDTO;
    }
}
