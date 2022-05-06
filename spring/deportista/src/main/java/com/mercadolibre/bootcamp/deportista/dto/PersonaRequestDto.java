package com.mercadolibre.bootcamp.deportista.dto;


public class PersonaRequestDto {

    /**
     * Atributos
     */
    private String name;
    private String surName;
    private int age;
    private String sportName;

    /**
     * Constructor
     *
     * @param
     */
    public PersonaRequestDto(String name, String surName, int edad, String deporte) {
        this.name = name;
        this.surName = surName;
        this.age = edad;
        this.sportName = deporte;
    }

    @Override
    public String toString() {
        return "PersonaRequestDto{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", edad=" + age +
                ", deporte=" + sportName +
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }
}
