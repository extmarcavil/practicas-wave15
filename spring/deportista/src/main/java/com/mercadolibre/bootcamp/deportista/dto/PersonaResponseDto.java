package com.mercadolibre.bootcamp.deportista.dto;

import org.springframework.stereotype.Component;


public class PersonaResponseDto {


    /**
     * Atributos
     */
    private String name;
    private String surName;
    private DeporteDto sportName;


    /**
     * Constructor
     *
     * @param sportName
     */
    public PersonaResponseDto(String name, String surName, DeporteDto sportName) {
        this.name = name;
        this.surName = surName;
        this.sportName = sportName;
    }

    @Override
    public String toString() {
        return "PersonaResponseDto{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", sportName='" + sportName + '\'' +
                '}';
    }

    /**
     * Getter y Setter
     *
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public DeporteDto getSportName() {
        return sportName;
    }

    public void setSportName(DeporteDto sportName) {
        this.sportName = sportName;
    }


}
