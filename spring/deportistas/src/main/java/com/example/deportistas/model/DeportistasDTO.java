package com.example.deportistas.model;

import java.io.Serializable;
import java.util.ArrayList;

public class DeportistasDTO implements Serializable {
    private String name;
    private String surname;
    private ArrayList<String> sportsNames;

    public DeportistasDTO(String name, String surname, ArrayList<String> sportsNames) {
        this.name = name;
        this.surname = surname;
        this.sportsNames = sportsNames;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public ArrayList<String> getSportsNames() {
        return sportsNames;
    }
}
