package com.dtos.athletes.controller;

import com.dtos.athletes.dto.Athlete;
import com.dtos.athletes.models.Person;
import com.dtos.athletes.models.Sport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@ResponseBody
public class SportController {

    private List<Sport> sports;
    private Map<Person, Sport> athletes;

    public SportController() {
        sports = new ArrayList<>();
        Sport tennis = new Sport("Tenis", "Dificil");
        Sport baseball = new Sport("Beisbol", "Dificil");
        Sport volleyball = new Sport("Voleibol", "Medio");
        Sport basketball = new Sport("Baloncesto", "Medio");
        sports.add(tennis);
        sports.add(baseball);
        sports.add(volleyball);
        sports.add(basketball);

        athletes = new HashMap<>();
        athletes.put(new Person("Javier", "Ferrante", 22), tennis);
        athletes.put(new Person("Miriam", "Herrera", 19), baseball);
        athletes.put(new Person("Lilian", "Murcia", 24), volleyball);
        athletes.put(new Person("Mario", "Kolen", 27), baseball);
    }

    @GetMapping("/findSports")
    public List<Sport> findSport() {
        return getSports();
    }

    @GetMapping("findSport/{name}")
    public Sport findSport(@PathVariable String name) {
        for (Sport sport : sports) {
            if (sport.getName().equals(name)) return sport;
        }
        return null;
    }

    @GetMapping("/findSportsPeople")
    public List<Athlete> findAthletes() {
        List<Athlete> athletesDTO = new ArrayList<>();
        athletes.forEach((p, s) -> {
            athletesDTO.add(new Athlete(p.getName(), p.getSurname(), s.getName()));
        });
        return athletesDTO;
    }

    public List<Sport> getSports() {
        return sports;
    }

}
