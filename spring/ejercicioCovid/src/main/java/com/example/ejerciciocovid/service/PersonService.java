package com.example.ejerciciocovid.service;

import com.example.ejerciciocovid.dto.RiskPersonDTO;
import com.example.ejerciciocovid.model.Person;
import com.example.ejerciciocovid.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService implements IPersonService {
    private PersonRepository personRepo;

    public PersonService() {
        this.personRepo = new PersonRepository();
    }

    public List<Person> getPersonsList() {
        return personRepo.getPersonsList();
    }

    public List<RiskPersonDTO> getRiskPersonsList() {
        List<RiskPersonDTO> riskPersons = new ArrayList<>();

        personRepo.getPersonsList().stream()
               .filter(x -> x.isOld() /*&& p.hasSymptoms()*/).collect(Collectors.toList())
               .forEach(x -> riskPersons.add(new RiskPersonDTO(x.getName(), x.getLastName())));

       return riskPersons;
    }
}
