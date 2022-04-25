package com.bootcamp.covid.service;

import com.bootcamp.covid.dto.SymptomDTO;
import com.bootcamp.covid.model.Symptom;


import java.util.ArrayList;
import java.util.List;

import static com.bootcamp.covid.repository.SymptomRepository.listSymptom;

public class SymptomService {

    public static List<SymptomDTO> findSymptom(){
        List<SymptomDTO> symptomDTO = new ArrayList<>();
        for (Symptom symptom : listSymptom) {
            symptomDTO.add(new SymptomDTO(symptom));
        }
        return symptomDTO;
    }

    public static SymptomDTO findSymptomByName(String name){
        Symptom symptom = listSymptom.stream()
                .filter(d -> d.getName().equals(name))
                .findFirst().orElse(null);
        return symptom != null ? new SymptomDTO(symptom) : null;
    }



}
