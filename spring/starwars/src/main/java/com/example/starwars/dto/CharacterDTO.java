package com.example.starwars.dto;

public class CharacterDTO {
  private String name;
  private String gender;
  private String homeworld;
  private String species;
  private Integer height;
  private Integer mass;

  public CharacterDTO() {
  }

  public CharacterDTO(String name, String gender, String homeworld, String species, Integer height, Integer mass) {
    this.name = name;
    this.gender = gender;
    this.homeworld = homeworld;
    this.species = species;
    this.height = height;
    this.mass = mass;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getHomeworld() {
    return homeworld;
  }

  public void setHomeworld(String homeworld) {
    this.homeworld = homeworld;
  }

  public String getSpecies() {
    return species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public Integer getMass() {
    return mass;
  }

  public void setMass(Integer mass) {
    this.mass = mass;
  }
}
