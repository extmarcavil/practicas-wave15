package com.mercadolibre.calculadorametroscuadrados.dto;

import lombok.Data;

import java.util.List;
@Data
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
}
