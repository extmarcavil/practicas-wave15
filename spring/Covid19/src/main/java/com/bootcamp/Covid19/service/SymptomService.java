package com.bootcamp.Covid19.service;


import com.bootcamp.Covid19.dto.SymptomDTO;
import com.bootcamp.Covid19.model.Symptom;
import com.bootcamp.Covid19.repository.SymptomRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SymptomService implements ISymptomService{

    private SymptomRepo symptoRepo;
    private ModelMapper mapper = new ModelMapper();

    public SymptomService (){ symptoRepo = new SymptomRepo();}

    //Listar todos los sintomas
    @Override
    public List<SymptomDTO> get_symptomsDTO(){
        return symptoRepo.get_symptoms().stream()
                .map(symptom -> mapper.map(symptom,SymptomDTO.class))
                .collect(Collectors.toList());
    }

    //Buscar sintoma por nombre
    @Override
    public SymptomDTO get_symptomByNameDTO(String name){
        Symptom sintoma = symptoRepo.get_symptomName(name)
                .orElseThrow(() -> new RuntimeException("NOT FOUND"));
        return mapper.map(sintoma,SymptomDTO.class);
    }
}
