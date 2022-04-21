package com.example.deportistas.repository;

import com.example.deportistas.model.Sport;

import java.util.ArrayList;

public class SportsRepository {
    private int index = 0;
    private ArrayList<Sport> sports = new ArrayList<>();

    public SportsRepository(){
        AddSport(new Sport("Padel",10));
        AddSport(new Sport("Futbol",1));
        AddSport(new Sport("Tenis",8));
    }

    public boolean AddSport(Sport sport){
        sport.setId(index++ + "");

        sports.add(sport);
        return true;
    }

    public ArrayList<Sport> getSports() {
        return sports;
    }

    public Sport findByName(String name){
        return sports.stream()
                .filter(s->s.getName().toLowerCase().equals(name.toLowerCase()))
                .findFirst()
                .orElse(null);
    }

    public Sport findById(String id){
        return sports.stream()
                .filter(s->s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
