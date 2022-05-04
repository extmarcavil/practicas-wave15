package com.mercadolibre.calculadorametroscuadrados.dto;

import java.util.Objects;

public class RoomDTO {
  private String name;
  private Integer width;
  private Integer length;

  public RoomDTO() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getLength() {
    return length;
  }

  public void setLength(Integer length) {
    this.length = length;
  }

  public Integer getSquareFeet() {
    Integer result = 0;
    if(this.width != null && this.length != null)
      result = this.width * this.length;
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RoomDTO roomDTO = (RoomDTO) o;
    return Objects.equals(name, roomDTO.name) && Objects.equals(width, roomDTO.width) && Objects.equals(length, roomDTO.length);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, width, length);
  }
}
