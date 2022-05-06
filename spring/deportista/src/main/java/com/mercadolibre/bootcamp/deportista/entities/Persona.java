package com.mercadolibre.bootcamp.deportista.entities;

import com.mercadolibre.bootcamp.deportista.dto.DeporteDto;


public class Persona {

    /**
     * Atributos
     */
    private String name;
    private String surName;
    private int age;
    private DeporteDto sport;


    /**
     * Getter & Setter
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public DeporteDto getSport() {
        return sport;
    }

    public void setSport(DeporteDto sport) {
        this.sport = sport;
    }
}
