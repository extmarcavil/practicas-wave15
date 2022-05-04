package com.mercadolibre.calculadorametroscuadrados.dto;

import java.util.List;
import java.util.Objects;

public class HouseDTO {
  private String name;
  private String address;
  private List<RoomDTO> rooms;

  public HouseDTO() {

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public List<RoomDTO> getRooms() {
    return rooms;
  }

  public void setRooms(List<RoomDTO> rooms) {
    this.rooms = rooms;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    HouseDTO houseDTO = (HouseDTO) o;
    return Objects.equals(name, houseDTO.name) && Objects.equals(address, houseDTO.address) && Objects.equals(rooms, houseDTO.rooms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, address, rooms);
  }
}
