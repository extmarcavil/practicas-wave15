package com.example.covid.dto;

import com.example.covid.model.Sintoma;

import java.util.ArrayList;

public class PersonDTO {
    private String fullName;
    private ArrayList<SintomaDTO> sintomas;

    public PersonDTO(String fullName, ArrayList<SintomaDTO> sintomas) {
        this.fullName = fullName;
        this.sintomas = sintomas;
    }

    public ArrayList<SintomaDTO> getSintomas() {
        return sintomas;
    }

    public void setSintomas(ArrayList<SintomaDTO> sintomas) {
        this.sintomas = sintomas;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
