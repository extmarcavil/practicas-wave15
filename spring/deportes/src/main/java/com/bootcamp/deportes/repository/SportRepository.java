package com.bootcamp.deportes.repository;

import com.bootcamp.deportes.dtos.SportDTO;
import com.bootcamp.deportes.model.Person;
import com.bootcamp.deportes.model.Sport;


import java.util.ArrayList;
import java.util.List;

public class SportRepository {
    public static List<Sport> listSport = new ArrayList<>();
    static {
        List<Person> listPerson = new ArrayList<>();
        listSport.add(new Sport("Natacion","Alto"));
        listSport.add(new Sport("Futbol","Bajo"));
        listSport.add(new Sport("Basketboll","Medio"));
    }

}
