package com.bootcamp.deportes.service;

import com.bootcamp.deportes.dtos.PersonSportDTO;
import com.bootcamp.deportes.dtos.SportDTO;
import com.bootcamp.deportes.model.Person;
import com.bootcamp.deportes.model.Sport;

import java.util.ArrayList;
import java.util.List;

import static com.bootcamp.deportes.repository.SportRepository.listSport;
import static com.bootcamp.deportes.repository.PersonRepository.listPerson;

public class SportService {
    public static List<SportDTO> getSport(){
        List<SportDTO> sportsDTO = new ArrayList<>();
        for (Sport sport : listSport) {
            sportsDTO.add(new SportDTO(sport));
        }
        return sportsDTO;
    }

    public static SportDTO findSportByName(String name){
        Sport sport = listSport.stream()
                .filter(d -> d.getName().equals(name))
                .findFirst().orElse(null);
        return sport != null ? new SportDTO(sport) : null;
    }

    public static  List<PersonSportDTO> getPersonSport(){
        List<PersonSportDTO> personSportDTO = new ArrayList<>();

        for(Person person : listPerson){
            for (Sport sport : listSport) {
                personSportDTO.add(new PersonSportDTO(person, sport));
            }break;
        }
        return personSportDTO;
    }
}
