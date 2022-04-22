package com.bootcamp.deportes.repository;

import com.bootcamp.deportes.dtos.SportDTO;
import com.bootcamp.deportes.model.Person;
import com.bootcamp.deportes.model.Sport;

import java.util.ArrayList;
import java.util.List;

public class SportRepository {
    static List<Sport> listSport = new ArrayList<>();
    //static debido a que lo couparemos dentro del packcage
    static {
        List<Person> listPerson = new ArrayList<>();
        listSport.add(new Sport("Natacion","Alto"));
        listSport.add(new Sport("Futbol","Bajo"));
        listSport.add(new Sport("Basketboll","Medio"));
    }

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

}
