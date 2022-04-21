package com.ejerciciointegrador.covid19.controller;

import com.ejerciciointegrador.covid19.dto.RiskPersonDTO;
import com.ejerciciointegrador.covid19.dto.SymptomDTO;
import com.ejerciciointegrador.covid19.model.Symptom;
import com.ejerciciointegrador.covid19.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Symptoms {

    private Repository symptomRepository;

    public Symptoms() {
        symptomRepository = new Repository();
    }

    @GetMapping(path = "/findSymptom")
    public List<Symptom> findSymptoms() {
        return symptomRepository.getSymptoms();
    }

    @GetMapping(path = "/findSymptom/{name}")
    public ResponseEntity<SymptomDTO> findSymptom(@PathVariable String name) {
        Symptom symptom = null;
        for (Symptom s : symptomRepository.getSymptoms()) {
            if (s.getName().equals(name)){
                symptom = s;
                break;
            }
        }

        return new ResponseEntity<>(new SymptomDTO(symptom.getSeverityLevel()), HttpStatus.OK);
    }

    @GetMapping(path = "/findRiskPeople")
    public ResponseEntity<List<RiskPersonDTO>> findRiskPeople() {

         List<RiskPersonDTO> riskPeopleDTO = symptomRepository.getPeople().stream().
                 filter(person -> person.getAge() > 60 && !person.getSymptomList().isEmpty()).
                 map(person ->
                     new RiskPersonDTO(person.getName() + " " + person.getSurname(),
                                        person.getAge(), new SymptomDTO(person.getSymptom().getName()))
                 ).
                 collect(Collectors.toList());
         return new ResponseEntity<>(riskPeopleDTO, HttpStatus.OK);
    }
}
