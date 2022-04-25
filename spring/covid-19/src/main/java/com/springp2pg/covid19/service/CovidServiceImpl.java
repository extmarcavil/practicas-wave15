package com.springp2pg.covid19.service;

import com.springp2pg.covid19.dto.RiskPersonDTO;
import com.springp2pg.covid19.dto.SymptomDTO;
import com.springp2pg.covid19.entity.Person;
import com.springp2pg.covid19.entity.Symptom;
import com.springp2pg.covid19.repository.ICovidRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CovidServiceImpl implements ICovidService{

    private ICovidRepository covidRepository;

    public CovidServiceImpl(ICovidRepository covidRepository) {
        this.covidRepository = covidRepository;
    }

    @Override
    public List<Symptom> getAllSymptom() {
        return covidRepository.getAllSymptoms();
    }

    @Override
    public SymptomDTO findSymptom(String name) {
        return new SymptomDTO(covidRepository.findSymptom(name).getSeverity_level());
    }

    @Override
    public List<RiskPersonDTO> findRiskPeople() {
        List<Person> riskPerson = covidRepository.findRiskPerson();

        List<RiskPersonDTO> riskPersonDTO = riskPerson.stream()
                .map(p -> new RiskPersonDTO(p.getName(),p.getLastName()))
                .collect(Collectors.toList());
        return riskPersonDTO;
    }
}
