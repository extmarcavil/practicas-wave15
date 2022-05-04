package com.mercadolibre.starwars.dto;

import java.util.Objects;

public class CharacterDTO {
  private String name;
  private String hair_color;
  private String skin_color;
  private String eye_color;
  private String birth_year;
  private String gender;
  private String homeworld;
  private String species;
  private Integer height;
  private Integer mass;

  public CharacterDTO() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getHair_color() {
    return hair_color;
  }

  public void setHair_color(String hair_color) {
    this.hair_color = hair_color;
  }

  public String getSkin_color() {
    return skin_color;
  }

  public void setSkin_color(String skin_color) {
    this.skin_color = skin_color;
  }

  public String getEye_color() {
    return eye_color;
  }

  public void setEye_color(String eye_color) {
    this.eye_color = eye_color;
  }

  public String getBirth_year() {
    return birth_year;
  }

  public void setBirth_year(String birth_year) {
    this.birth_year = birth_year;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CharacterDTO that = (CharacterDTO) o;
    return Objects.equals(name, that.name) && Objects.equals(hair_color, that.hair_color) && Objects.equals(skin_color, that.skin_color) && Objects.equals(eye_color, that.eye_color) && Objects.equals(birth_year, that.birth_year) && Objects.equals(gender, that.gender) && Objects.equals(homeworld, that.homeworld) && Objects.equals(species, that.species) && Objects.equals(height, that.height) && Objects.equals(mass, that.mass);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, hair_color, skin_color, eye_color, birth_year, gender, homeworld, species, height, mass);
  }
}
