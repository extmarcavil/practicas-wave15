package com.bootcamp.covid.service;

import com.bootcamp.covid.dto.PatientDTO;
import com.bootcamp.covid.dto.SymptomDTO;
import com.bootcamp.covid.repository.ISymptomRepository;
import com.bootcamp.covid.repository.SymptomRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SymptomService implements ISymptomService{

    ISymptomRepository repository;

    public SymptomService ( ISymptomRepository repository) {
        this.repository = repository;
    }

    public List<SymptomDTO> getSymptoms () {
        return repository.getAllSymptoms();
    }

    public SymptomDTO getSymptomDTO ( String name ) {
        try {
            SymptomDTO symptom = repository.getSymptomByName(name)
              .orElseThrow(() -> new RuntimeException("NOT FOUND"));
            return symptom;
        } catch (RuntimeException e) {
            return new SymptomDTO("ERROR", e.getMessage(), "NONE");
        }
    }

    public List<PatientDTO> getPatients () {
        List<PatientDTO> patients = repository.getPeople()
          .stream()
          .map(riskPersons -> new PatientDTO(riskPersons.getName(), riskPersons.getLastName(), riskPersons.getSymptoms()))
          .collect(Collectors.toList());
        return patients;
    }

}
