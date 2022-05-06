package com.bootcamp.covid.repository;

import com.bootcamp.covid.dto.PersonaDto;
import com.bootcamp.covid.dto.SintomaDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SintomaRepositoryImpl implements ISintomaRepository {
    List<SintomaDto> symptoms;
    List<PersonaDto> people;

    /**
     * Constructor
     */
    public SintomaRepositoryImpl() {
        symptoms = new ArrayList<>();
        people = new ArrayList<>();
        initData();
    }

    /**
     * Metodos
     *
     * @return
     */
    @Override
    public List<SintomaDto> getAllSymptoms() {
        return symptoms;
    }

    @Override
    public Optional<SintomaDto> getSymptomByName(String name) {
        return symptoms.stream()
                .filter(s -> s.getName()
                        .equals(name))
                .findFirst();
    }

    @Override
    public List<PersonaDto> getRiskpeople() {
        List<PersonaDto> riskPeople = people.stream()
                .filter(p -> p.isOld() && p.hasSymptoms())
                .collect(Collectors.toList());
        return riskPeople;
    }

    /***********************************************************/
    private void initData() {
        SintomaDto headache = new SintomaDto("S-01", "headache", "Low");
        SintomaDto queasiness = new SintomaDto("S-02", "queasiness", "Low");
        SintomaDto dizziness = new SintomaDto("S-03", "dizziness", "Low");
        SintomaDto fatigue = new SintomaDto("S-04", "fatigue", "Low");
        SintomaDto musclePain = new SintomaDto("S-05", "musclePain", "Low");

        PersonaDto lenore = new PersonaDto(1L, "Lenore", "Shilvock", 25, List.of(headache));
        PersonaDto wenona = new PersonaDto(1L, "Wenona", "Paddefield", 65, new ArrayList<>());
        PersonaDto ade = new PersonaDto(1L, "Ade", "Asple", 75, Arrays.asList(dizziness, musclePain));
        PersonaDto nicholle = new PersonaDto(1L, "Nicholle", "Abrahamsen", 61, Arrays.asList(fatigue, queasiness));

        this.people.addAll(Arrays.asList(lenore, wenona, ade, nicholle));
        this.symptoms.addAll(Arrays.asList(headache, queasiness, dizziness, fatigue, musclePain));
    }
}
