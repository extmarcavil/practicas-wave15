package com.example.ejerciciocovid.service;

import com.example.ejerciciocovid.dto.RiskPersonDTO;
import com.example.ejerciciocovid.dto.SymptomDTO;
import com.example.ejerciciocovid.model.Symptom;
import com.example.ejerciciocovid.repository.ISymptomRepository;
import com.example.ejerciciocovid.repository.SymptomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SymptomService implements ISymptomService {

    private ISymptomRepository symptomRepo;

    public SymptomService(ISymptomRepository symptomRepo) {
        this.symptomRepo = symptomRepo;
    }

    public List<SymptomDTO> getSymptomsList() {
        List<SymptomDTO> symptomDTOList = new ArrayList<>();
        symptomRepo.getSymptomsList()
                .forEach(x -> symptomDTOList.add(new SymptomDTO(x.getName(), x.getSeverityLevel())));

        return symptomDTOList;
    }

    public SymptomDTO getSymptomDTO(String name) {
        Symptom symptom = symptomRepo.getSymptomByName(name).orElse(null);

        if(symptom != null)
            return new SymptomDTO(symptom.getName(), symptom.getSeverityLevel());
        else return null;
    }
}
