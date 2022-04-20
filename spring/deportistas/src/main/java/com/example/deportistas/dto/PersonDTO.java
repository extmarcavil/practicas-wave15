package com.example.deportistas.dto;

import java.io.Serializable;

public class PersonDTO implements Serializable{
    private String personFullName;
    private String sportName;

    public String getPersonFullName() {
        return personFullName;
    }

    public void setPersonFullName(String personFullName) {
        this.personFullName = personFullName;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }
}
