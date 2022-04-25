package com.bootcamp.covid.repository;

import com.bootcamp.covid.dto.PersonDTO;
import com.bootcamp.covid.dto.SymptomDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SymptomRepository implements ISymptomRepository{
    List<SymptomDTO> symptoms;
    List<PersonDTO>  people;

    public SymptomRepository () {
        symptoms = new ArrayList<>();
        people   = new ArrayList<>();
        initData();
    }

    @Override
    public List<SymptomDTO> getAllSymptoms () {
        return symptoms;
    }

    @Override
    public Optional<SymptomDTO> getSymptomByName ( String name ) {
        return symptoms.stream()
          .filter(s -> s.getName()
            .equals(name))
          .findFirst();
    }

    @Override
    public List<PersonDTO> getPeople () {
        List<PersonDTO> riskPeople = people.stream()
          .filter(p -> p.isOld() && p.hasSymptoms())
          .collect(Collectors.toList());
        return riskPeople;
    }

    private void initData () {
        SymptomDTO headache   = new SymptomDTO("S-01", "headache", "Low");
        SymptomDTO queasiness = new SymptomDTO("S-02", "queasiness", "Low");
        SymptomDTO dizziness  = new SymptomDTO("S-03", "dizziness", "Low");
        SymptomDTO fatigue    = new SymptomDTO("S-04", "fatigue", "Low");
        SymptomDTO musclePain = new SymptomDTO("S-05", "musclePain", "Low");

        PersonDTO lenore   = new PersonDTO(1L, "Lenore", "Shilvock", 25, List.of(headache));
        PersonDTO wenona   = new PersonDTO(1L, "Wenona", "Paddefield", 65, new ArrayList<>());
        PersonDTO ade      = new PersonDTO(1L, "Ade", "Asple", 75, Arrays.asList(dizziness, musclePain));
        PersonDTO nicholle = new PersonDTO(1L, "Nicholle", "Abrahamsen", 61, Arrays.asList(fatigue, queasiness));

        this.people.addAll(Arrays.asList(lenore, wenona, ade, nicholle));
        this.symptoms.addAll(Arrays.asList(headache, queasiness, dizziness, fatigue, musclePain));
    }
}
