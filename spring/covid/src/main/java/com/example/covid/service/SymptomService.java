package com.example.covid.service;

import com.example.covid.dto.PersonDTO;
import com.example.covid.dto.SymptomDTO;
import com.example.covid.repository.ISymptomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SymptomService implements ISymptomService {

    private final ISymptomRepository repository;

    public SymptomService(ISymptomRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SymptomDTO> getSymptons(){
        return repository.getAllSymptoms();
    }

    @Override
    public SymptomDTO getSymptomSeverityLevelDTO(String name){
        return repository.getSymptomByName(name).orElse(null);
    }

    @Override
    public List<PersonDTO> getRiskPersonsDTO(){
        List<PersonDTO> riskPersons = repository.getRiskPersons().stream()
                .map(p -> new PersonDTO(p.getFullName(), p.getAge(), p.getSymptomsString()))
                .collect(Collectors.toList());
        return riskPersons;
    }
}
