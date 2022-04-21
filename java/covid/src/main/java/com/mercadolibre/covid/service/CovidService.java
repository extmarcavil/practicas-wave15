package com.mercadolibre.covid.service;

import com.mercadolibre.covid.dto.RiskPersonDto;
import com.mercadolibre.covid.model.Person;
import com.mercadolibre.covid.model.Symptom;
import com.mercadolibre.covid.repository.PersonRepository;
import com.mercadolibre.covid.repository.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CovidService {

    private final SymptomRepository symptomRepository;
    private final PersonRepository personRepository;

    @Autowired
    public CovidService(SymptomRepository symptomRepository, PersonRepository personRepository) {
        this.symptomRepository = symptomRepository;
        this.personRepository = personRepository;
    }

    @PostConstruct
    private void loadSomeRisks() {
        personRepository.findAllForUpdate(person -> {
            List<Symptom> symptoms = symptomRepository.findWithLimit(2);
            person.addSymptom(symptoms);
        });
    }

    public List<Symptom> findAll() {
        return symptomRepository.findAll();
    }

    public Symptom findByName(String name) {
        return symptomRepository.findAll().stream()
                .filter(symptom -> symptom.getName().equals(name))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public List<RiskPersonDto> findAllRiskPerson() {
        return personRepository.findAll().stream()
                .filter(Person::isRiskPerson)
                .map(RiskPersonDto::from)
                .collect(Collectors.toList());
    }
}
